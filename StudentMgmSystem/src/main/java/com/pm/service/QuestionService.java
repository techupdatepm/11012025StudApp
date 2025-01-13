package com.pm.service;

import java.util.List;

import com.pm.entity.Question;

public interface QuestionService {

	List<Question> viewAllQuestion();

	Question qusetDtlsById(Integer id);

}
