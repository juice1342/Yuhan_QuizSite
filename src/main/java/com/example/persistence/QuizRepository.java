package com.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
