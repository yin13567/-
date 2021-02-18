package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.CoursetableDao;
import com.fuhao55170725.examsys.jpa.dao.PaperStuDao;
import com.fuhao55170725.examsys.jpa.dao.TestPaperDao;
import com.fuhao55170725.examsys.jpa.entity.Coursetable;
import com.fuhao55170725.examsys.jpa.entity.PaperStu;
import com.fuhao55170725.examsys.jpa.entity.Testpaper;
import com.fuhao55170725.examsys.jsf.model.ExaminfoBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("examinfoCtrl")
@RequestScoped
public class ExaminfoCtrl {
	@Inject @Named("userInfoBean")
	UserInfoBean user;
	
	@Inject @Named("examinfoBean")
	private ExaminfoBean eib;
	
	@Inject @Named("userExamCtrl")
	UserExamCtrl uecl;
	
	@EJB
	private PaperStuDao psd;
	
	@EJB
	private TestPaperDao tpd;
	
	@EJB
	private CoursetableDao ctd;
	
	//设置信息
	public void setAllCourseInfo() {
		if(user.getUserid()==null) {
			user.setUserid("123465");
			user.setId(1);
		}
		
		List<Testpaper>TestPaperDatas=tpd.findAllTestPaper();
		List<Coursetable> CoursetableDatas=ctd.findAllCoursetable();
		
		List<Integer>fitPaperIds=new ArrayList<Integer>();
		List<String>fitPaperNames=new ArrayList<String>();
		List<Integer>fitCourseIds=new ArrayList<Integer>();
		List<String>fitCourseNames=new ArrayList<String>();
		
		for(int i=0;i<TestPaperDatas.size();i++) {
			Testpaper tmptp=TestPaperDatas.get(i);
			int paperid=tmptp.getId();
			int courseid=tmptp.getBycourseid();
			String papername=tmptp.getName();
			String coursename="";
			for(int j=0;j<CoursetableDatas.size();j++) {
				if(CoursetableDatas.get(j).getId()==courseid) {
					coursename=CoursetableDatas.get(j).getName();
				}
			}
			fitPaperIds.add(paperid);
			fitPaperNames.add(papername);
			fitCourseIds.add(courseid);
			fitCourseNames.add(coursename);
			
		}
		eib.setCoursetableIds(fitCourseIds);
		eib.setCoursetableNames(fitCourseNames);
		eib.setTestIds(fitPaperIds);
		eib.setTestNames(fitPaperNames);
	}

	//给用户增加一个考试
	public void addCourse(ActionEvent event) {
		int dbuserid=user.getId();
		long dbpaperid=(int)event.getComponent().getAttributes().get("courseid");
		
		PaperStu ps=new PaperStu();
		ps.setStuid(dbuserid);
		ps.setTestpaperid((int)dbpaperid);
		ps.setGrade(0);
		psd.addPaperStu(ps);
		uecl.setAllCourseInfo();
		//System.out.println("传递的参数:"+dbpaperid);
	}
}
