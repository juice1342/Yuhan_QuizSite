package com.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int question_no;
	
	@ManyToOne
	@JoinColumn(name="quiz_id")
	QuizName quizName;
	
	private String quiz;
	private String quiz_answer;
	private String quiz_photo_path;
	
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
	public String getQuiz_photo_path() {
		return quiz_photo_path;
	}
	public void setQuiz_photo_path(String quiz_photo_path) {
		this.quiz_photo_path = quiz_photo_path;
	}
	@Override
	public String toString() {
		return "Quiz [question_no=" + question_no + ", quizName=" + quizName + ", quiz=" + quiz + ", quiz_answer="
				+ quiz_answer + ", quiz_photo_path=" + quiz_photo_path + "]";
	}

}
