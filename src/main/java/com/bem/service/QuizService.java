package com.bem.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bem.domain.Quiz;
import com.bem.domain.QuizDto;
import com.bem.domain.QuizDtoWrapper;
import com.bem.repository.QuizRepository;

@Component
public class QuizService {
	@Resource
	private QuizRepository quizRepository;
	
	public List<QuizDto> getAll(){
		List<Quiz> list = quizRepository.findAll();
		List<QuizDto> quizs= new ArrayList<QuizDto>();
		for(Quiz quiz : list) {
			QuizDto thisQuiz= new QuizDto();
			thisQuiz.setQuestion(quiz.getQuestion());
			String[] answers = quiz.getAnswer().split("\\###");
			thisQuiz.setAnswers(answers);
			quizs.add(thisQuiz);
		}
		
		return quizs;
	}
	
	public List<QuizDto> getRandom(){
		List<Quiz> list = quizRepository.findByRodaom();
		List<QuizDto> quizs= new ArrayList<QuizDto>();
		for(Quiz quiz : list) {
			QuizDto thisQuiz= new QuizDto();
			thisQuiz.setQuestion(quiz.getQuestion());
			String[] answers = quiz.getAnswer().split("\\###");
			thisQuiz.setAnswers(answers);
			quizs.add(thisQuiz);
		}
		
		return quizs;
	}
	
	public boolean checkAnswer(String [] an){
		int len = an.length;
		List<Quiz> list = quizRepository.findAll();
		boolean check = true;
		for(int i = 0;i<len;i++){
			if(Integer.parseInt(an[i]) != list.get(i).getCorrect()){
				check = false;
			}
		}
		System.err.println(check);
		return check;
	}
	
	public boolean checkAnswers(String [] an,QuizDtoWrapper quizDto){
		int len = an.length;
		boolean check = true;
		for(int i = 0;i<len;i++){
			Quiz currentQuiz = quizRepository.findByQuestion(quizDto.getQuizDto().get(i).getQuestion());
			if(Integer.parseInt(an[i]) != currentQuiz.getCorrect()){
				check = false;
			}
		}
		System.err.println(check);
		return check;
		
	}
	
}
