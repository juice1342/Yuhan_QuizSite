package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.QuizName;

public interface QuizNameRepository extends JpaRepository<QuizName, Integer> {

}
