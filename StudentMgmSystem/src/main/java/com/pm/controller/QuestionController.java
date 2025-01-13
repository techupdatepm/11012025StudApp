package com.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.entity.Question;
import com.pm.service.QuestionService;

@RestController
@RequestMapping("/api/quest")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/viewAllQuest")
	public ResponseEntity<?> viewAllQuestion(){
		List<Question> list =questionService.viewAllQuestion();
		return ResponseEntity.status(HttpStatus.OK).body(list);
		
	}
	
	@GetMapping("/questDtls/{questId}")
	public ResponseEntity<?> qusetDtlsById(@PathVariable("questId") Integer id){
		Question question = questionService.qusetDtlsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(question);
		
	}
	
	
	

}
