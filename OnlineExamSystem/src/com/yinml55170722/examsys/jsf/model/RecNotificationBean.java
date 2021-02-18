package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
@Named("recNotificationBean")
@SessionScoped
public class RecNotificationBean   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -388740208029864489L;
	private List<String> coursename;
	private List<String> content;
	private List<String> time;
	private List<String> pubuser;
	public List<String> getCoursename() {
		return coursename;
	}
	public void setCoursename(List<String> coursename) {
		this.coursename = coursename;
	}
	public List<String> getContent() {
		return content;
	}
	public void setContent(List<String> content) {
		this.content = content;
	}
	public List<String> getTime() {
		return time;
	}
	public void setTime(List<String> time) {
		this.time = time;
	}
	public List<String> getPubuser() {
		return pubuser;
	}
	public void setPubuser(List<String> pubuser) {
		this.pubuser = pubuser;
	}
	
	
}
