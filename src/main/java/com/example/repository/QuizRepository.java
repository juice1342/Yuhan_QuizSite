package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
