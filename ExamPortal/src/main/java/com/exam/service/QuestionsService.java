package com.exam.service;

import java.util.Set;

import com.exam.models.exam.Questions;
import com.exam.models.exam.Quiz;


public interface QuestionsService {
	public Questions addQuestions(Questions questions);

	public Questions updateQuestions(Questions questions);

	public Questions getQuestionsById(Long questionId);

	public void deleteQuestions(Long questionId);
	
	public Set<Questions> getQuestionsOfQuiz(Quiz quiz);
}
