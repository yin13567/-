package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("rankingBean")
@SessionScoped
public class RankingBean  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5159424125715878276L;
	private int paperid;
	private List<Integer>userid;
	private List<Integer>grade;
	public int getPaperid() {
		return paperid;
	}
	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}
	public List<Integer> getUserid() {
		return userid;
	}
	public void setUserid(List<Integer> userid) {
		this.userid = userid;
	}
	public List<Integer> getGrade() {
		return grade;
	}
	public void setGrade(List<Integer> grade) {
		this.grade = grade;
	}
	
	
}
