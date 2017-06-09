package com.bem.domain;


public class QuizDto {
	private String question;
	private String[] answers;
	
	
	
	public QuizDto() {
		super();
	}
	
	public QuizDto(String question, String[] answers) {
		super();
		this.question = question;
		this.answers = answers;
	}

	public QuizDto(String question) {
		super();
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getAnswers() {
		return answers;
	}
	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
	
	
}
