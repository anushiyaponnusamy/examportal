package com.exam.service.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.models.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.service.QuizService;
@Service
public class QuizServiceImpl implements QuizService{
	@Autowired
	QuizRepository quizRepository;


	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuiz() {
		return new LinkedHashSet<>( this.quizRepository.findAll());

	}

	@Override
	public Quiz getQuizById(Long quizId) {
		return this.quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizID) {
		Quiz quiz=new Quiz();
		quiz.setQid(quizID);
		this.quizRepository.delete(quiz);
	}
}
