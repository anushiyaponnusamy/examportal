package com.exam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.models.exam.Questions;
import com.exam.models.exam.Quiz;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long>{

	Set<Questions> findByQuiz(Quiz quiz);

}
