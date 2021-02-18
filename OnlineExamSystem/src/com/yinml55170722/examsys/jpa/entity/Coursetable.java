package com.fuhao55170725.examsys.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the coursetable database table.
 * 
 */
@Entity
@NamedQuery(name="Coursetable.findAll", query="SELECT c FROM Coursetable c")
public class Coursetable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name="questionbank_name")
	private String questionbankName;

	public Coursetable() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestionbankName() {
		return this.questionbankName;
	}

	public void setQuestionbankName(String questionbankName) {
		this.questionbankName = questionbankName;
	}

}