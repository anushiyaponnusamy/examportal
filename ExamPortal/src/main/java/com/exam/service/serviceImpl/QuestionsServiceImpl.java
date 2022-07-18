package com.exam.service.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.models.exam.Questions;
import com.exam.models.exam.Quiz;
import com.exam.repository.QuestionsRepository;
import com.exam.service.QuestionsService;
@Service
public class QuestionsServiceImpl implements QuestionsService {

	@Autowired
	QuestionsRepository questionsRepository;
	
	@Override
	public Questions addQuestions(Questions questions) {
		return this.questionsRepository.save(questions);
	}

	@Override
	public Questions updateQuestions(Questions questions) {
		
		return this.questionsRepository.save(questions);
		}

	

	@Override
	public Questions getQuestionsById(Long questionId) {
		
		return this.questionsRepository.findById(questionId).get();
	}

	
	@Override
	public void deleteQuestions(Long questionId) {
		Questions questions=new Questions();
		questions.setQuestionId(questionId);
	this.questionsRepository.delete(questions);
	}

	@Override
	public Set<Questions> getQuestionsOfQuiz(Quiz quiz) {
		return this.questionsRepository.findByQuiz(quiz);
	}
}
