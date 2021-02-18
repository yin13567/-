package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("purePaperBean")
@SessionScoped
public class PurePaperBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4606251130864098152L;
	private int queid;//试卷的id
	private List<String>content;//试卷问题
	private List<String>ans;//试卷答案
	
	
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
	public int getQueid() {
		return queid;
	}
	public void setQueid(int queid) {
		this.queid = queid;
	}
	
	
}
