package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
@Named("forUserInfoBean")
@SessionScoped
public class ForUserInfoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8312510458870977636L;
	private int id;
	private String userid;
	private String userpasswd;
	private String userpasswd2;
	private int age;
	private int gender;
	private int role;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpasswd() {
		return userpasswd;
	}
	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserpasswd2() {
		return userpasswd2;
	}
	public void setUserpasswd2(String userpasswd2) {
		this.userpasswd2 = userpasswd2;
	}
	
	
}
