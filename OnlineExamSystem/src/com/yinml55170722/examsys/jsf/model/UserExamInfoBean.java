package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("userExamInfoBean")
@SessionScoped
public class UserExamInfoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2061328513988074661L;
	
	private List<String>courseNames;
	private List<Integer>courseId;
	private List<String>examNames;
	private List<Integer>examId;
	
	public List<String> getCourseNames() {
		return courseNames;
	}
	public void setCourseNames(List<String> courseNames) {
		this.courseNames = courseNames;
	}
	public List<Integer> getCourseId() {
		return courseId;
	}
	public void setCourseId(List<Integer> courseId) {
		this.courseId = courseId;
	}
	public List<String> getExamNames() {
		return examNames;
	}
	public void setExamNames(List<String> examNames) {
		this.examNames = examNames;
	}
	public List<Integer> getExamId() {
		return examId;
	}
	public void setExamId(List<Integer> examId) {
		this.examId = examId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
