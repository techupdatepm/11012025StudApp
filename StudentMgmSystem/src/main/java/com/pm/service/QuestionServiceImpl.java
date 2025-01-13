package com.pm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.entity.Question;
import com.pm.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService { 
	@Autowired
	QuestionRepository questionRepository;

	@Override
	public List<Question> viewAllQuestion() {
		List<Question> list=null;
		try {
			list =questionRepository.findAll();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Question qusetDtlsById(Integer id) {
		Question quest=null;
		try {
		Optional<Question>	optquest =questionRepository.findById(id);
		if(optquest != null)
			quest=optquest.get();
			System.out.println(quest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quest;
		
	}

}
