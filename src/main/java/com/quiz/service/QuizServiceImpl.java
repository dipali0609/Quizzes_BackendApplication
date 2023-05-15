package com.quiz.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.quiz.dao.Quiz;
import com.quiz.dao.QuizStatus;
import com.quiz.error.GlobalExceptionHandling;
import com.quiz.repository.QuizRepository;
 
@Service
public class QuizServiceImpl implements QuizService
{ 
	@Autowired
	private QuizRepository quizRepository;

	public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        quiz.setStatus(QuizStatus.INACTIVE);
        return quizRepository.save(quiz);
    }

    @Override
    public ResponseEntity<Object> getActiveQuiz() {  
    	LocalDateTime now = LocalDateTime.now();
    	System.out.println(now);
    	  List<Quiz> quizzes = quizRepository.findByStatus("active");
    	  if (quizzes.isEmpty()) {
    	    return ResponseEntity.notFound().build();
    	  } else {
    	    Quiz activeQuiz = quizzes.get(0);
    	    return ResponseEntity.ok(activeQuiz);
    	  }
    }
     
    @Override
    public Quiz getQuizById(Long id) throws GlobalExceptionHandling
    {
    	Optional<Quiz> q=quizRepository.findById(id);
    	if(!q.isPresent())
    	{
    		throw new GlobalExceptionHandling(id+" Is Not Present");
    	}
    	else
    	{
    		return quizRepository.findById(id).orElse(null);
    	}
        
        
    }
    
    @Override
	public String getResult(Long id) throws GlobalExceptionHandling 
    {
    	Optional<Quiz> q=quizRepository.findById(id);
    	if(!q.isPresent())
    	{
    		throw new GlobalExceptionHandling(id+" Is Not Present");
    	}
    	else
    	{
    		//return quizRepository.getResult(id);
        	String result = null;
        	Optional<Quiz> optionalQuiz = quizRepository.findById(id);
            if (optionalQuiz.isPresent()) {
                Quiz quiz = optionalQuiz.get();
                LocalDateTime quizEndTime = quiz.getEndDate().plusMinutes(5);
                if (LocalDateTime.now().isAfter(quizEndTime)) 
                {
                     result = "The correct answer is: " + quiz.getRightAnswer();
                }
                else
                {
                	result="The quiz result is not available yet";
                }
            }
    		return result;	
    	}
		
    }
    
    @Override
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
    
}
		
	

	
	
	


