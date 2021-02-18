package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.CourseTeaDao;
import com.fuhao55170725.examsys.jpa.dao.CoursetableDao;
import com.fuhao55170725.examsys.jpa.entity.CourseTea;
import com.fuhao55170725.examsys.jpa.entity.Coursetable;
import com.fuhao55170725.examsys.jsf.model.CreatecourseBean;
import com.fuhao55170725.examsys.jsf.model.UserInfoBean;

@Named("createcourseCtrl")
@RequestScoped
public class CreatecourseCtrl {
	
	@Inject @Named("createcourseBean")
	private CreatecourseBean ccb;
	
	@Inject @Named("userInfoBean")
	private UserInfoBean user;
	
	@EJB
	private CourseTeaDao ctd;
	
	@EJB
	private CoursetableDao cd;
	//存储bean的信息
	public void save() {
		Coursetable cbn=new Coursetable();
		
		cbn.setName(ccb.getName());
		cbn.setQuestionbankName(ccb.getBankname());
		
		cd.addCoursetable(cbn);
		
	
		
		int courseid=0;
		List<Coursetable>cbDatas=cd.findAllCoursetable();
		for(int i=0;i<cbDatas.size();i++) {
			Coursetable tmpcf=cbDatas.get(i);
			if(tmpcf.getName().equals(ccb.getName())&&tmpcf.getQuestionbankName().equals(ccb.getBankname())) {
				courseid=tmpcf.getId();
				break;
			}
		}
		System.out.println("Id: "+courseid);
		
		CourseTea ctn=new CourseTea();
		ctn.setCourseid(courseid);
		ctn.setTeaid(ccb.getTeaid());
		
		ctd.addCourseTea(ctn);
		
	}
}
