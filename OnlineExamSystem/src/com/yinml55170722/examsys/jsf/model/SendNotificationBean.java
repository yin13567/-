package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("sendNotificationBean")
@SessionScoped
public class SendNotificationBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5737252951311100761L;

	private String content;
	private int courseid;
	private int userid;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
