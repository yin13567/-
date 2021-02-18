package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("allPaperBean")
@SessionScoped
public class AllPaperBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 579813913594443666L;
	private List<String>papername;
	private List<Integer>paperid;
	public List<String> getPapername() {
		return papername;
	}
	public void setPapername(List<String> papername) {
		this.papername = papername;
	}
	public List<Integer> getPaperid() {
		return paperid;
	}
	public void setPaperid(List<Integer> paperid) {
		this.paperid = paperid;
	}
	
	
}
