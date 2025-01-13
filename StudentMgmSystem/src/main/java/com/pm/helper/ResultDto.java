package com.pm.helper;

import java.util.List;

public class ResultDto {

	private int studId;
	private List<AttendeQuestionDto> atendeCorrectAnsList; // List of answers for the student
	private int totalMark;
	private String studName;
	private String studEmail;
	private String studMob;
	private String studAddr;

	public int getStudId() {
		return studId;

	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public List<AttendeQuestionDto> getAtendeCorrectAnsList() {
		return atendeCorrectAnsList;
	}

	public void setAtendeCorrectAnsList(List<AttendeQuestionDto> atendeCorrectAnsList) {
		this.atendeCorrectAnsList = atendeCorrectAnsList;
	}

	public int getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudEmail() {
		return studEmail;
	}

	public void setStudEmail(String studEmail) {
		this.studEmail = studEmail;
	}

	public String getStudMob() {
		return studMob;
	}

	public void setStudMob(String studMob) {
		this.studMob = studMob;
	}

	public String getStudAddr() {
		return studAddr;
	}

	public void setStudAddr(String studAddr) {
		this.studAddr = studAddr;
	}

}
