package com.example.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "QUIZ_NAME")
public class QuizName {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int quiz_id;
	private String user_id;
	private String quiz_title;
		
	private Date createDate=new Date();
	
	@OneToMany(mappedBy = "quizName", cascade = CascadeType.ALL)
    private List<Quiz> quizzes;

    public void setQuiz(Quiz quiz) {
        if (quizzes == null) {
            quizzes = new ArrayList<>();
        }
        quizzes.add(quiz);
        quiz.setQuizName(this);
    }
	
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public String getQuiz_title() {
		return quiz_title;
	}
	public void setQuiz_title(String quiz_title) {
		this.quiz_title = quiz_title;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	// private String user_id;
	// 나중에 유저 아이디, 닉네임 넣기
//	//private String user_id;
//		@ManyToOne
//		@JoinColumn(name = "user_id" )
//		User user;
	
}