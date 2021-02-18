package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("pubbankquesionBean")
@SessionScoped
public class PubbankquesionBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8777742763224524762L;
	private List<Integer>questionid;
	private List<String>questioncontent;
	private String bankname;
	public List<Integer> getQuestionid() {
		return questionid;
	}
	public void setQuestionid(List<Integer> questionid) {
		this.questionid = questionid;
	}
	public List<String> getQuestioncontent() {
		return questioncontent;
	}
	public void setQuestioncontent(List<String> questioncontent) {
		this.questioncontent = questioncontent;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	
}
