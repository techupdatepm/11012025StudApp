package com.pm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.entity.ExamEntity;
import com.pm.helper.StudExamDto;
import com.pm.service.ExamService;
@RestController
@RequestMapping("/api/exam")
public class ExamController {
	
	@Autowired
	ExamService examService;
	
	@PostMapping("/attend")
	public ResponseEntity<?> attendExamination(@RequestBody StudExamDto dto){
		String msg=examService.attendExamination(dto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(msg);
		
	}
	@GetMapping("/viewAll")
	public ResponseEntity<?> viewAll(){
		List<ExamEntity> examList=examService.viewAll();
		return ResponseEntity.status(HttpStatus.OK).body(examList);
		
	}
	@GetMapping("/examResult")
	public ResponseEntity<?> examResult(){
		Map<String,Object> examList=examService.getExamResults();
		return ResponseEntity.status(HttpStatus.OK).body(examList);
		
	}
	@GetMapping("/examResultByStudId/{studId}")
	public ResponseEntity<?> examResultByStudId(@PathVariable("studId") Integer id){
		Map<String,Object> examList=examService.getExamDtlsByStudId(id);
		return ResponseEntity.status(HttpStatus.OK).body(examList);
		
	}
}
