package com.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.QuizName;

public interface QuizNameRepository extends JpaRepository<QuizName, Integer> {

}
