package com.pm.helper;

import java.util.List;

public class StudExamDto {
	private int studId;
	private List<AnswerDto> ansList;
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public List<AnswerDto> getAnsList() {
		return ansList;
	}
	public void setAnsList(List<AnswerDto> ansList) {
		this.ansList = ansList;
	}
	@Override
	public String toString() {
		return "StudExamDto [studId=" + studId + ", ansList=" + ansList + "]";
	}
	

}
