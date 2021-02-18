package com.fuhao55170725.examsys.jsf.ctrl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jms.AsyncMesConsumer;
import com.fuhao55170725.examsys.jms.JMSProducer;
import com.fuhao55170725.examsys.jpa.dao.CourseTeaDao;
import com.fuhao55170725.examsys.jpa.dao.CoursetableDao;
import com.fuhao55170725.examsys.jpa.dao.NoticetableDao;
import com.fuhao55170725.examsys.jpa.dao.PaperStuDao;
import com.fuhao55170725.examsys.jpa.dao.TestPaperDao;
import com.fuhao55170725.examsys.jpa.entity.CourseTea;
import com.fuhao55170725.examsys.jpa.entity.Coursetable;
import com.fuhao55170725.examsys.jpa.entity.Noticetable;
import com.fuhao55170725.examsys.jsf.model.CourseBean;
import com.fuhao55170725.examsys.jsf.model.CourseteaBean;
import com.fuhao55170725.examsys.jsf.model.JmsBean;
import com.fuhao55170725.examsys.jsf.model.SendNotificationBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("sendNotificationCtrl")
@RequestScoped
public class SendNotificationCtrl {
	
	@Inject @Named("userInfoBean")
	private UserInfoBean user;
	
	@Inject @Named("sendNotificationBean")
	private SendNotificationBean snb;
	
	@Inject @Named("courseteaBean")
	private CourseteaBean cb;
	
	@Inject @Named("courseBean")
	private CourseBean csb;
	
	@Inject @Named("jmsBean")
	private JmsBean jb;
	
	@EJB
	private PaperStuDao psd;
	
	@EJB 
	private CoursetableDao cd;
	
	@EJB
	private TestPaperDao tpd;
	
	@EJB 
	private NoticetableDao nd;
	
	@EJB
	private CourseTeaDao ctd;
	
	
	
	//设置所有的信息
	public void setAllInfo() {
		if(user.getUserid()==null) {
			user.setId(2);
			user.setUserid("55170700");
		}
		
		List<CourseTea>ctDatas=ctd.findAllCourseTea();
		List<Coursetable>courDatas=cd.findAllCoursetable();
		
		List<Integer>courseIds=new ArrayList<Integer>();
		List<String>courseNames=new ArrayList<String>();
		for(int i=0;i<ctDatas.size();i++) {
			CourseTea tmpctf=ctDatas.get(i);
			if(tmpctf.getTeaid()==user.getId()) {
				courseIds.add(tmpctf.getCourseid());
			}
		}
		
		for(int i=0;i<courseIds.size();i++) {
			int tmpidf=courseIds.get(i);
			for(int j=0;j<courDatas.size();j++) {
				Coursetable tmpctf= courDatas.get(j);
				if(tmpctf.getId()==tmpidf) {
					courseNames.add(tmpctf.getName());
				}
			}
		}
		
		csb.setCourseid(courseIds);
		csb.setCoursename(courseNames);
		
		System.out.println("courseIds size:"+courseIds.size());
		System.out.println("courseNames size:"+courseNames.size());
	}
	//提交通知
	public void sendNoti() {
		if(user.getUserid()==null) {
			user.setId(2);
			user.setUserid("55170700");
		}
		int courseid=csb.getSelectId();
		
		Noticetable ntn=new Noticetable();
		ntn.setContent(snb.getContent());
		ntn.setByuserid(user.getId());
		ntn.setFromcourse(courseid);
		Date date=new Date();
		Timestamp pubtime=new Timestamp(date.getTime());
		ntn.setPubtime(pubtime);
		
		nd.addNoticetable(ntn);
		
		try {
			new JMSProducer().product(snb.getContent());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println(jb.getContent());
	}
}
