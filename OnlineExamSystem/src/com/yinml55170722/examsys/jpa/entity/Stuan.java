package com.fuhao55170725.examsys.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stuans database table.
 * 
 */
@Entity
@Table(name="stuans")
@NamedQuery(name="Stuan.findAll", query="SELECT s FROM Stuan s")
public class Stuan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ans;

	private int grade;

	private int paperid;

	private int quesid;

	private int stuid;

	public Stuan() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAns() {
		return this.ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getPaperid() {
		return this.paperid;
	}

	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}

	public int getQuesid() {
		return this.quesid;
	}

	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}

	public int getStuid() {
		return this.stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

}