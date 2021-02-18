package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("createcourseBean")
@SessionScoped
public class CreatecourseBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3173507644002020841L;
	private String name;
	private String bankname;
	private int teaid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTeaid() {
		return teaid;
	}
	public void setTeaid(int teaid) {
		this.teaid = teaid;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	
}
