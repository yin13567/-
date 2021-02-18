package com.fuhao55170725.examsys.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the paper_stu database table.
 * 
 */
@Entity
@Table(name="paper_stu")
@NamedQuery(name="PaperStu.findAll", query="SELECT p FROM PaperStu p")
public class PaperStu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int grade;

	private int stuid;

	private int testpaperid;

	public PaperStu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getStuid() {
		return this.stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public int getTestpaperid() {
		return this.testpaperid;
	}

	public void setTestpaperid(int testpaperid) {
		this.testpaperid = testpaperid;
	}

}