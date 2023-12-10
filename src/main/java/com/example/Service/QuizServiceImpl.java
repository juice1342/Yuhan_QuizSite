package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Quiz;
import com.example.entity.QuizName;
import com.example.repository.QuizNameRepository;
import com.example.repository.QuizRepository;

@Service
public class QuizServiceImpl {
	@Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizNameRepository quizNameRepository;

    @Transactional
    public void insertQuiz(Quiz quiz, String quizTitle) {
        // Quiz 객체를 생성하고 QuizName과의 관계를 설정하여 저장
        QuizName quizName = new QuizName();
        quizName.setQuiz_title(quizTitle);

        quizNameRepository.save(quizName);

        quiz.setQuizName(quizName);
        quizRepository.save(quiz);
    }

    public void updateQuiz(Quiz quiz) {
        Quiz quizfind = quizRepository.findById(quiz.getQuestion_no()).orElse(null);
        if (quizfind != null) {
            quizfind.setQuiz(quiz.getQuiz());
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
    
    public QuizName getQuizName1(QuizName quizname) {		 
 	   return quizNameRepository.findById(quizname.getQuiz_id()).get();
 	 }
    
    public List<Quiz> getQuizList() {
        return (List<Quiz>) quizRepository.findAll();
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
        return quizNameRepository.findById(quizName.getQuiz_id()).get();
    }

    public List<QuizName> getQuizNameList(QuizName quizname) {
        return (List<QuizName>) quizNameRepository.findAll();
    }	
    
//    public List<QuizName> getQuizNameList(QuizName quizname) {
//        List<QuizName> quizNameList = (List<QuizName>) quizNameRepository.findAll();
//        System.out.println("QuizName List: " + quizNameList);
//        return quizNameList;
//    }
}
