package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.fuhao55170725.examsys.jpa.entity.Coursetable;
@Named("examinfoBean")
@SessionScoped
public class ExaminfoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4723436014845357177L;
	
	private List<String>coursetableNames;
	private List<Integer>coursetableIds;
	private List<String>testNames;
	private List<Integer>testIds;
	public List<String> getCoursetableNames() {
		return coursetableNames;
	}
	public void setCoursetableNames(List<String> coursetableNames) {
		this.coursetableNames = coursetableNames;
	}
	public List<Integer> getCoursetableIds() {
		return coursetableIds;
	}
	public void setCoursetableIds(List<Integer> coursetableIds) {
		this.coursetableIds = coursetableIds;
	}
	public List<String> getTestNames() {
		return testNames;
	}
	public void setTestNames(List<String> testNames) {
		this.testNames = testNames;
	}
	public List<Integer> getTestIds() {
		return testIds;
	}
	public void setTestIds(List<Integer> testIds) {
		this.testIds = testIds;
	}
	
	
}
