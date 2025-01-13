package com.pm.helper;

public class AnswerDto {
	
	private int questId;
	private String answer;
	
	public int getQuestId() {
		return questId;
	}
	public void setQuestId(int questId) {
		this.questId = questId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "AnswerDto [questId=" + questId + ", answer=" + answer + "]";
	}

}
