package com.fuhao55170725.examsys.jsf.model;


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("quelistBean")
@SessionScoped
public class QuelistBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3531487235746521005L;
	private List<Integer>ids;
	private List<String>contents;
	private int paperid;
	
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public List<String> getContents() {
		return contents;
	}
	public void setContents(List<String> contents) {
		this.contents = contents;
	}
	public int getPaperid() {
		return paperid;
	}
	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}
	
	
}
