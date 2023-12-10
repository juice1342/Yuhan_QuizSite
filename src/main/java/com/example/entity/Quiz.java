package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "QUIZ")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int question_no;
	
	@ManyToOne	// (cascade = CascadeType.ALL)
	@JoinColumn(name = "quiz_id")
	private QuizName quizName;
	
	private String quiz;
	private String quiz_answer;
	
	private List<String> quizList;
    private List<String> answerList;
	
    
    
    
	public List<String> getQuizList() {
		return quizList;
	}
	public void setQuizList(List<String> quizList) {
		this.quizList = quizList;
	}
	public List<String> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<String> answerList) {
		this.answerList = answerList;
	}
	
	
	public int getQuestion_no() {
		return question_no;
	}
	public void setQuestion_no(int question_no) {
		this.question_no = question_no;
	}
	public QuizName getQuizName() {
		return quizName;
	}
	public void setQuizName(QuizName quizName) {
		this.quizName = quizName;
	}
	public String getQuiz() {
		return quiz;
	}
	public void setQuiz(String quiz) {
		this.quiz = quiz;
	}
	public String getQuiz_answer() {
		return quiz_answer;
	}
	public void setQuiz_answer(String quiz_answer) {
		this.quiz_answer = quiz_answer;
	}
	@Override
	public String toString() {
		return "Quiz [question_no=" + question_no + ", quizName=" + quizName + ", quiz=" + quiz + ", quiz_answer="
				+ quiz_answer + ", quiz_photo_path=" + "]";
	}
}
