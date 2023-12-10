package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Quiz;
import com.example.domain.QuizName;
import com.example.persistence.QuizNameRepository;
import com.example.persistence.QuizRepository;

@Service
public class QuizServiceImpl {
	 @Autowired
	    private QuizRepository quizRepository;

	    @Autowired
	    private QuizNameRepository quizNameRepository;

	    public void insertQuiz(Quiz quiz) {
	        quizRepository.save(quiz);
	    }

	    public void updateQuiz(Quiz quiz) {
	        Quiz quizfind = quizRepository.findById(quiz.getQuestion_no()).orElse(null);
	        if (quizfind != null) {
	            quizfind.setQuiz(quiz.getQuiz());
	            quizfind.setQuiz_photo_path(quiz.getQuiz_photo_path());
	            quizfind.setQuiz_answer(quiz.getQuiz_answer());
	            quizRepository.save(quizfind);
	        }
	    }

	    public void deleteQuiz(Quiz quiz) {
	        quizRepository.deleteById(quiz.getQuestion_no());
	    }

	    public Quiz getQuiz(Quiz quiz) {
	        return quizRepository.findById(quiz.getQuestion_no()).orElse(null);
	    }

	    public List<Quiz> getQuizList() {
	        return (List<Quiz>) quizRepository.findAll();
	    }

	    public void insertQuizName(QuizName quizName) {
	    	quizNameRepository.save(quizName); // QuizName을 먼저 저장

	        // Quiz 객체를 생성하고 QuizName과의 관계를 설정하여 저장
	        Quiz quiz = new Quiz();
	        quiz.setQuizName(quizName);
	        quizRepository.save(quiz);
	    }

	    public void updateQuizName(QuizName quizName) {
	        QuizName quiznamefind = quizNameRepository.findById(quizName.getQuiz_id()).orElse(null);
	        if (quiznamefind != null) {
	            quiznamefind.setQuiz_title(quizName.getQuiz_title());
	            quizNameRepository.save(quiznamefind);
	        }
	    }

	    public void deleteQuizName(QuizName quizName) {
	        quizNameRepository.deleteById(quizName.getQuiz_id());
	    }

	    public QuizName getQuizName(QuizName quizName) {
	        return quizNameRepository.findById(quizName.getQuiz_id()).orElse(null);
	    }

	    public List<QuizName> getQuizNameList() {
	        return (List<QuizName>) quizNameRepository.findAll();
	    }	 
}
