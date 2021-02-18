package com.fuhao55170725.examsys.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the testpaper database table.
 * 
 */
@Entity
@NamedQuery(name="Testpaper.findAll", query="SELECT t FROM Testpaper t")
public class Testpaper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int bycourseid;

	private int byuserid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endtime;

	private String info;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date starttime;

	public Testpaper() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBycourseid() {
		return this.bycourseid;
	}

	public void setBycourseid(int bycourseid) {
		this.bycourseid = bycourseid;
	}

	public int getByuserid() {
		return this.byuserid;
	}

	public void setByuserid(int byuserid) {
		this.byuserid = byuserid;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

}