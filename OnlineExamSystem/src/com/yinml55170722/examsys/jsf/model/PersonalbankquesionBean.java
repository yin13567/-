package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("personalbankquesionBean")
@SessionScoped
public class PersonalbankquesionBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7033771676255866407L;
	private List<String> content;
	private List<String> ans;
	public List<String> getContent() {
		return content;
	}
	public void setContent(List<String> content) {
		this.content = content;
	}
	public List<String> getAns() {
		return ans;
	}
	public void setAns(List<String> ans) {
		this.ans = ans;
	}
	
	
}
