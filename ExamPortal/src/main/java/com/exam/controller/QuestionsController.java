package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.models.exam.Questions;
import com.exam.models.exam.Quiz;
import com.exam.service.QuestionsService;
import com.exam.service.QuizService;


@RestController
@RequestMapping("/questions")
@CrossOrigin("*")
public class QuestionsController {
	@Autowired
	private QuestionsService questionService;
	@Autowired
	private QuizService quizService;

	@PostMapping("/")
	public ResponseEntity<?> addQuestions(@RequestBody Questions questions){
		return ResponseEntity.ok(this.questionService.addQuestions(questions));
	}

	@PutMapping("/")
	public ResponseEntity<?> updateQuestions(@RequestBody Questions questions){
		return ResponseEntity.ok(this.questionService.updateQuestions(questions));
	}

	@GetMapping("/{questionId}")
	public Questions getQuestionsById(Long questionId) {
		return this.questionService.getQuestionsById(questionId);
	}

	@DeleteMapping("/{questionId}")
	public void deleteQuestions(@PathVariable("questionId") Long questionId) {
		this.questionService.deleteQuestions(questionId);
	}

	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long  qid){

		Quiz quiz=this.quizService.getQuizById(qid);
		Set<Questions> questions=quiz.getQuestion();
		List list=new ArrayList(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()+1)) {
			list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}

}
