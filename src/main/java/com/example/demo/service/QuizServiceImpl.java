package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Quiz;
import com.example.demo.entity.QuizName;
import com.example.demo.repository.QuizNameRepository;
import com.example.demo.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepository quizRepository;

	public void insertQuiz(Quiz quiz) {//저장기능
		quizRepository.save(quiz);
	}

	public void updateQuiz(Quiz quiz) {//수정기능
		 Quiz quizfind =quizRepository.findById(quiz.getQuestion_no()).get();
		 quizfind.setQuiz(quiz.getQuiz());
		 quizfind.setQuiz_photo_path(quiz.getQuiz_photo_path());
		 quizfind.setQuiz_answer(quiz.getQuiz_answer());
		 quizRepository.save(quizfind);//modify한다.		
	}

	public void deleteQuiz(Quiz quiz) {
		quizRepository.deleteById(quiz.getQuestion_no());		
	}

	public Quiz getQuiz(Quiz quiz) {
		return quizRepository.findById(quiz.getQuestion_no()).orElse(null);
	}

	public List<Quiz> getQuizList(Quiz quiz) {
		return (List<Quiz>) quizRepository.findAll();
	}

	@Autowired
	private QuizNameRepository quizNameRepository;
	
	public void insertQuizName(QuizName quizName) {
		quizNameRepository.save(quizName);
	}

	public void updateQuizName(QuizName quizName) {
		QuizName quiznamefind = quizNameRepository.findById(quizName.getQuiz_id()).get();
    	quiznamefind.setQuiz_title(quizName.getQuiz_title());
	    quizNameRepository.save(quizName);
	}

	public void deleteQuizName(QuizName quizName) {
		quizNameRepository.deleteById(quizName.getQuiz_id());
	}

	public QuizName getQuizName(QuizName quizName) {
		return quizNameRepository.findById(quizName.getQuiz_id()).orElse(null);
	}

	public List<QuizName> getQuizNameList(QuizName quizName) {
		return (List<QuizName>) quizNameRepository.findAll();
	}
	
}
