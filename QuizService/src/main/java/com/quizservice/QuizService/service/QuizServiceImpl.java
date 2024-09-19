package com.quizservice.QuizService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizservice.QuizService.entity.Quiz;
import com.quizservice.QuizService.repository.QuizRepository;

@Service
public class QuizServiceImpl  implements QuizService{

	@Autowired
	private QuizRepository quizRepo;
	
	private QuestionClient questionClient;
	
	
	
	public QuizServiceImpl(QuizRepository quizRepo,QuestionClient questionClient) {
		this.quizRepo = quizRepo;
		this.questionClient=questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepo.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		// TODO Auto-generated method stub
//		return quizRepo.findAll();
	List<Quiz> quizzes=quizRepo.findAll();
	List<Quiz> newQuizzesList=quizzes.stream().map(quiz->{
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}).collect(Collectors.toList());
	
	return newQuizzesList;
	}


    @Override
    public Quiz get(Long id) {

        Quiz quiz = quizRepo.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }

}
