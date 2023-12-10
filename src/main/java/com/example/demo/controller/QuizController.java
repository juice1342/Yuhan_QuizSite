package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Quiz;
import com.example.demo.entity.QuizName;
import com.example.demo.service.QuizServiceImpl;

@Controller
public class QuizController {
	@Autowired
    private QuizServiceImpl quizService;

    // 글등록 화면으로 이동
    @GetMapping("/insertQuiz")//get방식
    public String insertQuizView() {
        return "insertQuiz";
    }

    // 글등록
    @PostMapping("/insertQuiz")
    @Transactional
    public String insertQuiz(@ModelAttribute("quiz") Quiz quiz, @RequestParam("quizname") String quizTitle) {
        // 퀴즈 이름을 생성
        QuizName quizname = new QuizName();
        quizname.setQuiz_title(quizTitle);

        List<String> quizList = quiz.getQuizList();
        List<String> answerList = quiz.getAnswerList();

        // 퀴즈 객체의 리스트를 생성하고 저장하는 로직
        for (int i = 0; i < quizList.size(); i++) {
            String quizText = quizList.get(i);
            String answerText = answerList.get(i);

            Quiz quizS = new Quiz();
            quizS.setQuiz(quizText);
            quizS.setQuiz_answer(answerText);
            quizS.setQuizName(quizname);

            // insertQuiz 메서드가 단일 Quiz 객체를 처리
            quizService.insertQuiz(quizS, quizTitle);
        }

        // 퀴즈 이름을 저장
        // quizService.insertQuizName(quizname);

        return "forward:getQuizList";
    }

//    //글 리스트
//    @GetMapping("/getQuizList")
//    public String getQuizList(Model model) {
//        List<QuizName> quizNameList = quizService.getQuizNameList();
//        System.out.println("QuizName List: " + quizNameList);
//        model.addAttribute("quizNameList", quizNameList);
//        return "index";
//    }
    
    @RequestMapping("/getQuizNameList")
    public String getQuizNameList(QuizName quizname, Model model) {
        List<QuizName> quizNameList = quizService.getQuizNameList(quizname);
        System.out.println("QuizName List in Controller: " + quizNameList);
        model.addAttribute("quiznameList", quizNameList);
        return "index";
    }
    
	//글 상세 조회
    @GetMapping("/getQuiz")
    public String getQuiz(Quiz quiz, QuizName quizname, Model model) {
        model.addAttribute("quizname", quizService.getQuizName(quizname));
        model.addAttribute("quiz", quizService.getQuiz(quiz));
        return "getQuiz";
    }

//    //글 수정 
//    @PostMapping("/updateQuiz")
//    @Transactional
//    public String updateQuiz(Quiz quiz, QuizName quizname) {
//        quizService.updateQuiz(quiz);
//        quizService.updateQuizName(quizname);
//        return "forward:getQuizList";
//    } 

//    //글 삭제 
//    @GetMapping("/deleteQuiz")
//    public String deleteQuiz(Quiz quiz, QuizName quizname) {
//        quizService.deleteQuiz(quiz);
//        quizService.deleteQuizName(quizname);
//        return "forward:getQuizList";
//    } 
}