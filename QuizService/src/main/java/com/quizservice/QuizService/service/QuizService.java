package com.quizservice.QuizService.service;

import java.util.List;

import com.quizservice.QuizService.entity.Quiz;

public interface QuizService {

	Quiz add(Quiz quiz);
	
	List<Quiz> get();
	
	Quiz get(Long id);
}
