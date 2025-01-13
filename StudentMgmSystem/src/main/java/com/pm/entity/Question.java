package com.pm.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "qust_mgm")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qus_id")
	private int qusId;
	private String question;
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	private String correctAsn;
	
	@JsonIgnore
	 @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ExamEntity> resultList;

	public int getQusId() {
		return qusId;
	}

	public void setQusId(int qusId) {
		this.qusId = qusId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getOpt4() {
		return opt4;
	}

	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}

	public String getCorrectAsn() {
		return correctAsn;
	}

	public void setCorrectAsn(String correctAsn) {
		this.correctAsn = correctAsn;
	}
	

	public List<ExamEntity> getResultList() {
		return resultList;
	}

	public void setResultList(List<ExamEntity> resultList) {
		this.resultList = resultList;
	}

	

}
