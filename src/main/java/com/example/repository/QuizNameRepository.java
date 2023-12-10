package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.QuizName;

public interface QuizNameRepository extends JpaRepository<QuizName, Integer> {

}
