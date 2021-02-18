package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("courseBean")
@SessionScoped
public class CourseBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2135054664528811753L;
	private List<Integer>courseid;
	private List<String>coursename;
	private int selectId;//选择的科目id
	
	public List<Integer> getCourseid() {
		return courseid;
	}
	public void setCourseid(List<Integer> courseid) {
		this.courseid = courseid;
	}
	public List<String> getCoursename() {
		return coursename;
	}
	public void setCoursename(List<String> coursename) {
		this.coursename = coursename;
	}
	public int getSelectId() {
		return selectId;
	}
	public void setSelectId(int selectId) {
		this.selectId = selectId;
	}
	
	
}
