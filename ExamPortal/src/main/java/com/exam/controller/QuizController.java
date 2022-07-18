package com.exam.controller;

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

import com.exam.models.exam.Quiz;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
@Autowired
QuizService quizService;

@PostMapping("/")
public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {
	return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	
}

@PutMapping("/")
public ResponseEntity<?>  updateQuiz(@RequestBody Quiz quiz){
	return ResponseEntity.ok(this.quizService.updateQuiz(quiz));	
}

@GetMapping("/")
public ResponseEntity<?> getQuiz(){
	return ResponseEntity.ok(this.quizService.getQuiz());	
}
@GetMapping("/{qid}")
public Quiz getQuizById(@PathVariable("qid") Long quizId) {
	return this.quizService.getQuizById(quizId);
}

@DeleteMapping("/{qid}")
public void deleteQuiz(@PathVariable("qid") Long quizID) {
	this.quizService.deleteQuiz(quizID);
}
}
