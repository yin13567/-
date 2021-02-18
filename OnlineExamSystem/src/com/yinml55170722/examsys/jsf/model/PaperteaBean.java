package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("paperteaBean")
@SessionScoped
public class PaperteaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7418408019066746617L;
	private List<Integer>paperid;
	private List<String>paperNames;
	public List<Integer> getPaperid() {
		return paperid;
	}
	public void setPaperid(List<Integer> paperid) {
		this.paperid = paperid;
	}
	public List<String> getPaperNames() {
		return paperNames;
	}
	public void setPaperNames(List<String> paperNames) {
		this.paperNames = paperNames;
	}
	
	
}
