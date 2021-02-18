package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("userGradeBean")
@SessionScoped
public class UserGradeBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3746184431197830765L;
	private List<String> name;
	private List<Integer> grade;
	private List<Integer> ranking;
	public List<String> getName() {
		return name;
	}
	public void setName(List<String> name) {
		this.name = name;
	}
	public List<Integer> getGrade() {
		return grade;
	}
	public void setGrade(List<Integer> grade) {
		this.grade = grade;
	}
	public List<Integer> getRanking() {
		return ranking;
	}
	public void setRanking(List<Integer> ranking) {
		this.ranking = ranking;
	}
	
	
	
}
