package com.quiz.schedular;


import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.quiz.dao.Quiz;
import com.quiz.dao.QuizStatus;
import com.quiz.repository.QuizRepository;
import com.quiz.service.QuizService;

@Component
public class QuizScheduler {
	
@Autowired
private QuizRepository quizRepository;

@Transactional
@Scheduled(fixedRate = 6000) // run every minute
public void updateQuizStatuses() {
        List<Quiz> quizzes = quizRepository.findAll();
        System.out.println(quizzes);
        LocalDateTime now = LocalDateTime.now();
        for (Quiz quiz : quizzes) {
          if (now.isBefore(quiz.getStartDate())) {
            quiz.setStatus(QuizStatus.INACTIVE);
          } else if (now.isBefore(quiz.getEndDate())) {
            quiz.setStatus(QuizStatus.ACTIVE);
          } else {
            quiz.setStatus(QuizStatus.FINISHED);
          }
          quizRepository.save(quiz);
        }
      }

}
