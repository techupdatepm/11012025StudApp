package com.pm.service;

import java.util.List;
import java.util.Map;

import com.pm.entity.ExamEntity;
import com.pm.helper.StudExamDto;

public interface ExamService {

	String attendExamination(StudExamDto dto);

	Map<String,Object> getExamDtlsByStudId(int id);

	List<ExamEntity> viewAll();

	Map<String,Object> getExamResults();

}
