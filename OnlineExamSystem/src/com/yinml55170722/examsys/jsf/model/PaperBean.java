package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("paperBean")
@SessionScoped
public class PaperBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8080649161863437395L;
	private int num;//题目的个数
	private List<Integer>quesIds;
	private List<String>quesContent;
	private List<String>quesAns;
	private String paperName;
	private String paperIntro;
	private float paperTime;
	
	private List<Integer>bankIds;//题库中的题目
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List<Integer> getQuesIds() {
		return quesIds;
	}
	public void setQuesIds(List<Integer> quesIds) {
		this.quesIds = quesIds;
	}
	public List<Integer> getBankIds() {
		return bankIds;
	}
	public void setBankIds(List<Integer> bankIds) {
		this.bankIds = bankIds;
	}
	public List<String> getQuesContent() {
		return quesContent;
	}
	public void setQuesContent(List<String> quesContent) {
		this.quesContent = quesContent;
	}
	public List<String> getQuesAns() {
		return quesAns;
	}
	public void setQuesAns(List<String> quesAns) {
		this.quesAns = quesAns;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getPaperIntro() {
		return paperIntro;
	}
	public void setPaperIntro(String paperIntro) {
		this.paperIntro = paperIntro;
	}
	public float getPaperTime() {
		return paperTime;
	}
	public void setPaperTime(float paperTime) {
		this.paperTime = paperTime;
	}
	
	
}
