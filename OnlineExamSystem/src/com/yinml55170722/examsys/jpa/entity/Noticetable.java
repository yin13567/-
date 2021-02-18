package com.fuhao55170725.examsys.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the noticetable database table.
 * 
 */
@Entity
@NamedQuery(name="Noticetable.findAll", query="SELECT n FROM Noticetable n")
public class Noticetable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int byuserid;

	private String content;

	private int fromcourse;

	private Timestamp pubtime;

	public Noticetable() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getByuserid() {
		return this.byuserid;
	}

	public void setByuserid(int byuserid) {
		this.byuserid = byuserid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFromcourse() {
		return this.fromcourse;
	}

	public void setFromcourse(int fromcourse) {
		this.fromcourse = fromcourse;
	}

	public Timestamp getPubtime() {
		return this.pubtime;
	}

	public void setPubtime(Timestamp pubtime) {
		this.pubtime = pubtime;
	}

}