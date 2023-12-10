package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Quiz;
import com.example.demo.entity.QuizName;

public interface QuizService {
	public void insertQuiz(Quiz quiz);
	public void updateQuiz(Quiz quiz);
	public void deleteQuiz(Quiz quiz);
	public Quiz getQuiz(Quiz quiz);
	public List<Quiz> getQuizList (Quiz quiz);
	 
	public void insertQuizName(QuizName quizName);
	public void updateQuizName(QuizName quizName);
	public void deleteQuizName(QuizName quizName);
	public QuizName getQuizName(QuizName quizName);
	List<QuizName> getQuizNameList(QuizName quizName);
}
