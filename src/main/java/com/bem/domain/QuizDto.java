package com.bem.domain;


public class QuizDto {
	private String question;
	private String[] Answers;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getAnswers() {
		return Answers;
	}
	public void setAnswers(String[] answers) {
		Answers = answers;
	}
	
	
}
