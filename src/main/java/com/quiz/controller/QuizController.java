package com.quiz.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.dao.Quiz;
import com.quiz.error.GlobalExceptionHandling;
import com.quiz.service.QuizService;

@RestController
public class QuizController 
{
	@Autowired
    private QuizService quizService;

@PostMapping("/quizzes")
public ResponseEntity<Quiz> createQuiz(@Valid @RequestBody Quiz quiz)
{
	Quiz qq=quizService.createQuiz(quiz);
	return new ResponseEntity<Quiz>(qq,HttpStatus.CREATED);
}

@GetMapping("/quizzes/active")
public ResponseEntity<Object> getActiveQuizBystatus()
{
	return quizService.getActiveQuiz();	
}

@GetMapping("/quizzes/{id}")
public Quiz getQuizById(@PathVariable("id") Long id) throws GlobalExceptionHandling
{
	return quizService.getQuizById(id);	
}

@GetMapping("/quizzes/{id}/result")
public ResponseEntity<String> getResult(@Valid @PathVariable("id") Long id) throws GlobalExceptionHandling
{
	String q=quizService.getResult(id);
	return new ResponseEntity<String>(q,HttpStatus.CREATED);
}

@GetMapping("/quizzes/all")
List<Quiz> getAllQuizzes()
{
	return quizService.getAllQuizzes();
}

}
