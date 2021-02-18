package com.fuhao55170725.examsys.jsf.model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("allUserInfoBean")
@SessionScoped
public class AllUserInfoBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6580432944023057811L;
	private List<Integer>id;
	private List<String>userid;
	private List<String>passwd;
	private	List<Integer>age;
	private	List<Integer>gender;
	private	List<String>phone;
	private	List<Integer>role;
	public List<String> getUserid() {
		return userid;
	}
	public void setUserid(List<String> userid) {
		this.userid = userid;
	}
	public List<String> getPasswd() {
		return passwd;
	}
	public void setPasswd(List<String> passwd) {
		this.passwd = passwd;
	}
	public List<Integer> getAge() {
		return age;
	}
	public void setAge(List<Integer> age) {
		this.age = age;
	}
	public List<Integer> getGender() {
		return gender;
	}
	public void setGender(List<Integer> gender) {
		this.gender = gender;
	}
	public List<String> getPhone() {
		return phone;
	}
	public void setPhone(List<String> phone) {
		this.phone = phone;
	}
	public List<Integer> getRole() {
		return role;
	}
	public void setRole(List<Integer> role) {
		this.role = role;
	}
	public List<Integer> getId() {
		return id;
	}
	public void setId(List<Integer> id) {
		this.id = id;
	}
	
	
	
}
