package com.quiz.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.quiz.dao.Quiz;
import com.quiz.error.GlobalExceptionHandling;

public interface QuizService {

	public Quiz createQuiz(Quiz quiz);
	ResponseEntity<Object> getActiveQuiz();
    Quiz getQuizById(Long id) throws GlobalExceptionHandling;
    public String getResult(@Valid Long id) throws GlobalExceptionHandling;
    List<Quiz> getAllQuizzes();
	
	
	
}
