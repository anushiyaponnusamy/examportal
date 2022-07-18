package com.exam.service;

import java.util.Set;

import com.exam.models.exam.Quiz;

public interface QuizService {
	public Quiz addQuiz(Quiz quiz);

	public Quiz updateQuiz(Quiz quiz);

	public Set<Quiz> getQuiz();

	public Quiz getQuizById(Long quizId);

	public void deleteQuiz(Long quizID);
}
