package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Quiz;
import com.example.demo.entity.QuizName;
import com.example.demo.service.QuizServiceImpl;

@Controller
public class QuizController {
	@Autowired
	private QuizServiceImpl quizService;
	
	@GetMapping("/index")
    public String indexView() {
    	return "index";
    } 
	
	//글등록 화면으로 이동
    @GetMapping("/insertQuiz")//get방식
    public String insertQuizView() {
    	return "insertQuiz";
    }
    //글 등록
    @PostMapping("/insertQuiz")//post방식
    public String insertQuiz(Quiz quiz, QuizName quizname) {        	
    	quizService.insertQuiz(quiz);
    	quizService.insertQuizName(quizname);
    	return "forward:getBoardList";
    }
	//글 상세 조회
    @GetMapping("/getQuiz")
	public String getQuiz(Quiz quiz, QuizName quizname, Model model) {
    	model.addAttribute("quizname", quizService.getQuizName(quizname));    	
	     model.addAttribute("quiz", quizService.getQuiz(quiz));
	     return "getQuiz";		
	}
    //글 수정 
    @PostMapping("/updateQuiz")
    @Transactional
    public String updateQuiz(Quiz quiz, QuizName quizname) {
    	quizService.updateQuiz(quiz);
    	quizService.updateQuizName(quizname);
    	return "forward:getQuizList";
    } 
    //글 삭제 
    @GetMapping("/deleteQuiz")
    public String deleteQuiz(Quiz quiz, QuizName quizname) {
    	quizService.deleteQuiz(quiz);
    	quizService.deleteQuizName(quizname);
    	return "forward:getBoardList";
    } 
}
