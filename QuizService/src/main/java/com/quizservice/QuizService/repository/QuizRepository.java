package com.quizservice.QuizService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizservice.QuizService.entity.Quiz;


public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
