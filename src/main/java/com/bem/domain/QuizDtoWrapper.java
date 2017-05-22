package com.bem.domain;

import java.util.List;

public class QuizDtoWrapper {
	List<QuizDto> quizDto;
	String an;

	public List<QuizDto> getQuizDto() {
		return quizDto;
	}

	public void setQuizDto(List<QuizDto> quizDto) {
		this.quizDto = quizDto;
	}

	public String getan() {
		return an;
	}

	public void setan(String an) {
		this.an = an;
	} 
	
	
	
}
