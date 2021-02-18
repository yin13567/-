package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("jmsBean")
@SessionScoped
public class JmsBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6576910358042181953L;
	String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
