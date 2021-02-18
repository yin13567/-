package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("examPaperBean")
@SessionScoped
public class ExamPaperBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3158122912288368963L;
	private String name;//考试名称
	private List<Integer>tiankongId;
	private List<String>tiankong=new ArrayList<String>(100);;
	private List<String>tiankongAns=new ArrayList<String>(100);;
	private List<Integer>xuanzeId=new ArrayList<Integer>(100);;
	private List<String>xuanze=new ArrayList<String>(100);;
	private List<String>xuanzeAns=new ArrayList<String>(100);;
	private List<Integer>panduanId=new ArrayList<Integer>(100);;
	private List<String>panduan=new ArrayList<String>(100);;
	private List<String>panduanAns=new ArrayList<String>(100);;
	private List<Integer>wendaId=new ArrayList<Integer>(100);;
	private List<String>wenda=new ArrayList<String>(100);;
	private List<String>wendaAns=new ArrayList<String>(100);;
	
	private String que;
	private String ans;
	private int queid;
	
	
	public List<String> getTiankong() {
		return tiankong;
	}
	public void setTiankong(List<String> tiankong) {
		this.tiankong = tiankong;
	}
	public List<String> getXuanze() {
		return xuanze;
	}
	public void setXuanze(List<String> xuanze) {
		this.xuanze = xuanze;
	}
	public List<String> getPanduan() {
		return panduan;
	}
	public void setPanduan(List<String> panduan) {
		this.panduan = panduan;
	}
	public List<String> getWenda() {
		return wenda;
	}
	public void setWenda(List<String> wenda) {
		this.wenda = wenda;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getTiankongId() {
		return tiankongId;
	}
	public void setTiankongId(List<Integer> tiankongId) {
		this.tiankongId = tiankongId;
	}
	public List<Integer> getXuanzeId() {
		return xuanzeId;
	}
	public void setXuanzeId(List<Integer> xuanzeId) {
		this.xuanzeId = xuanzeId;
	}
	public List<Integer> getPanduanId() {
		return panduanId;
	}
	public void setPanduanId(List<Integer> panduanId) {
		this.panduanId = panduanId;
	}
	public List<Integer> getWendaId() {
		return wendaId;
	}
	public void setWendaId(List<Integer> wendaId) {
		this.wendaId = wendaId;
	}
	public List<String> getTiankongAns() {
		return tiankongAns;
	}
	public void setTiankongAns(List<String> tiankongAns) {
		this.tiankongAns = tiankongAns;
	}
	public List<String> getXuanzeAns() {
		return xuanzeAns;
	}
	public void setXuanzeAns(List<String> xuanzeAns) {
		this.xuanzeAns = xuanzeAns;
	}
	public List<String> getPanduanAns() {
		return panduanAns;
	}
	public void setPanduanAns(List<String> panduanAns) {
		this.panduanAns = panduanAns;
	}
	public List<String> getWendaAns() {
		return wendaAns;
	}
	public void setWendaAns(List<String> wendaAns) {
		this.wendaAns = wendaAns;
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public int getQueid() {
		return queid;
	}
	public void setQueid(int queid) {
		this.queid = queid;
	}
	
	
	
}

