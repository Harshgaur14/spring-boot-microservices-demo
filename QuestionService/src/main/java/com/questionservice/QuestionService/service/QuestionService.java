package com.questionservice.QuestionService.service;

import java.util.List;

import com.questionservice.QuestionService.entities.Question;

public interface QuestionService {

    Question create(Question question);
    List<Question> get();
    Question getOne(Long id);

    List<Question> getQuestionsOfQuiz(Long quizId);
}