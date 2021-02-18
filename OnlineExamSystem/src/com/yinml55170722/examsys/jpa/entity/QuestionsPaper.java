package com.fuhao55170725.examsys.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the questions_paper database table.
 * 
 */
@Entity
@Table(name="questions_paper")
@NamedQuery(name="QuestionsPaper.findAll", query="SELECT q FROM QuestionsPaper q")
public class QuestionsPaper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int grade;

	private int paperid;

	private int questionid;

	public QuestionsPaper() {
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

	public int getPaperid() {
		return this.paperid;
	}

	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}

	public int getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

}