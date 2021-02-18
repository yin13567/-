package com.fuhao55170725.examsys.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the course_tea database table.
 * 
 */
@Entity
@Table(name="course_tea")
@NamedQuery(name="CourseTea.findAll", query="SELECT c FROM CourseTea c")
public class CourseTea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int courseid;

	private int teaid;

	public CourseTea() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseid() {
		return this.courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public int getTeaid() {
		return this.teaid;
	}

	public void setTeaid(int teaid) {
		this.teaid = teaid;
	}

}