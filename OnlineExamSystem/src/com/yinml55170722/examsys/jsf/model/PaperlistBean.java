package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("paperlistBean")
@SessionScoped
public class PaperlistBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8749678328769566570L;
	private int id;
	private List<Integer>stuid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Integer> getStuid() {
		return stuid;
	}
	public void setStuid(List<Integer> stuid) {
		this.stuid = stuid;
	}
	
	
}
