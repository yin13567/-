package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("courseteaBean")
@SessionScoped
public class CourseteaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8156265185111484979L;
	private List<Integer> courseid;
	private List<String> courseName;
	private int selectid;
	
	public List<Integer> getCourseid() {
		return courseid;
	}
	public void setCourseid(List<Integer> courseid) {
		this.courseid = courseid;
	}
	public List<String> getCourseName() {
		return courseName;
	}
	public void setCourseName(List<String> courseName) {
		this.courseName = courseName;
	}
	public int getSelectid() {
		return selectid;
	}
	public void setSelectid(int selectid) {
		this.selectid = selectid;
	}
	
	
}
