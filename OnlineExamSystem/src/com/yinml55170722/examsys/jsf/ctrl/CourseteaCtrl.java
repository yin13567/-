package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.CourseTeaDao;
import com.fuhao55170725.examsys.jpa.dao.CoursetableDao;
import com.fuhao55170725.examsys.jpa.dao.QuestionDao;
import com.fuhao55170725.examsys.jpa.entity.CourseTea;
import com.fuhao55170725.examsys.jpa.entity.Coursetable;
import com.fuhao55170725.examsys.jpa.entity.Question;
import com.fuhao55170725.examsys.jsf.model.CourseteaBean;
import com.fuhao55170725.examsys.jsf.model.PaperBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("courseteaCtrl")
@RequestScoped
public class CourseteaCtrl {
	
	@Inject @Named("courseteaBean")
	private CourseteaBean ctb;
	
	@Inject @Named("userInfoBean")
	UserInfoBean user;
	
	@Inject @Named("paperBean")
	PaperBean pb;
	
	@EJB
	private CourseTeaDao ctd;
	
	@EJB
	private CoursetableDao ctad;
	
	@EJB
	private QuestionDao qd;
	
	//设置所有的信息
	public void setAllInfo() {
		if(user.getUserid()==null) {
			user.setId(2);
			user.setUserid("55170700");
		}
		ctb.setCourseid(null);
		ctb.setCourseName(null);
		List<Integer>idRes=new ArrayList<Integer>();
		List<String>nameRes=new ArrayList<String>();
		
		List<CourseTea>courseteaDatas=ctd.findAllCourseTea();
		List<Coursetable>coursetaleDatas=ctad.findAllCoursetable();
		
		for(int i=0;i<courseteaDatas.size();i++) {
			CourseTea tmpctf=courseteaDatas.get(i);
			if(tmpctf.getTeaid()==user.getId()) {
				idRes.add(tmpctf.getCourseid());
			}
		}
		for(int i=0;i<idRes.size();i++) {
			int id=idRes.get(i);
			for(int j=0;j<coursetaleDatas.size();j++) {
				Coursetable tmpctf=coursetaleDatas.get(j);
				if(id==tmpctf.getId()) {
					nameRes.add(tmpctf.getName());
				}
			}
		}
		ctb.setCourseid(idRes);
		ctb.setCourseName(nameRes);
	}
	//select
	public void setSelect(ActionEvent event) {
		int courseid=(int)event.getComponent().getAttributes().get("courseid");
		ctb.setSelectid(courseid);
		
		List<Integer> questionIds=new ArrayList<Integer>();
		List<Question>questionsDatas=qd.findQuestion();
		
		for(int i=0;i<questionsDatas.size();i++) {
			Question tmpqf=questionsDatas.get(i);
			if(tmpqf.getQb()==courseid) {
				questionIds.add(tmpqf.getId());
			}
		}
		pb.setBankIds(questionIds);
	}
}
