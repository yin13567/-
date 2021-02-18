package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("stuansBean")
@SessionScoped
public class StuansBean implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7028602841124040172L;
	private	int id;//学生id
	private int paperid;//试卷id
    private List<Integer>queid;
    private List<String>stuans;
    private double grade;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Integer> getQueid() {
		return queid;
	}
	public void setQueid(List<Integer> queid) {
		this.queid = queid;
	}
	public List<String> getStuans() {
		return stuans;
	}
	public void setStuans(List<String> stuans) {
		this.stuans = stuans;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getPaperid() {
		return paperid;
	}
	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}
    
    
}
