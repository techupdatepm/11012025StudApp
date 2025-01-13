package com.pm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
