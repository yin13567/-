package com.fuhao55170725.examsys.jsf.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.dao.CoursetableDao;
import com.fuhao55170725.examsys.jpa.entity.Coursetable;
import com.fuhao55170725.examsys.jsf.model.CourseBean;

@Named("courseCtrl")
@RequestScoped
public class CourseCtrl {
	@EJB
	private CoursetableDao cd;
	
	@Inject @Named("courseBean")
	private CourseBean cb;
	
	//设置所有信息
	public void setAllInfo() {
		List<Integer>idRes=new ArrayList<Integer>();
		List<String>nameRes=new ArrayList<String>();
		
		List<Coursetable>coursetableDatas=cd.findAllCoursetable();
		for(int i=0;i<coursetableDatas.size();i++) {
			Coursetable tmpcf=coursetableDatas.get(i);
			int idf=tmpcf.getId();
			String namef=tmpcf.getName();
			idRes.add(idf);
			nameRes.add(namef);
		}
		cb.setCourseid(idRes);
		cb.setCoursename(nameRes);
	}
	//设置选择的id
	public void selectId(ActionEvent event) {
		int courseid=(int)event.getComponent().getAttributes().get("courseid");
		cb.setSelectId(courseid);
	}
}
