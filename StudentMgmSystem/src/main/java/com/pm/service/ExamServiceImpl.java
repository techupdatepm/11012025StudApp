package com.pm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pm.entity.ExamEntity;
import com.pm.entity.Question;
import com.pm.entity.Student;
import com.pm.helper.AnswerDto;
import com.pm.helper.AttendeQuestionDto;
import com.pm.helper.ResultDto;
import com.pm.helper.StudExamDto;
import com.pm.repository.ExamRepository;

@Service
public class ExamServiceImpl implements ExamService {
	@Autowired
	ExamRepository examRepository;

	@Autowired
	QuestionService questionService;

	@Autowired
	StudentService studentService;

	@Override
	public String attendExamination(StudExamDto dto) {
		String msg = "";
		try {
			List<Question> qusList = questionService.viewAllQuestion();

			Student stud = studentService.getStudentById(dto.getStudId());

			for (AnswerDto ans : dto.getAnsList()) {

				// System.out.println(ans.getQuestId()+"/t"+ans.getAnswer());
				for (Question qut : qusList) {
					// System.out.println(qut.getQusId()+"/t"+qut.getQuestion()+"/t"+qut.getCorrectAsn());
					if (ans.getQuestId() == qut.getQusId()) {
						ExamEntity exam = new ExamEntity();
						exam.setStudent(stud);
						exam.setQuestion(qut);
						boolean ansStatus = false;
						if (ans.getAnswer().equalsIgnoreCase(qut.getCorrectAsn())) {
							ansStatus = true;

						}
						exam.setCorrectAns(ansStatus);
						examRepository.save(exam);

					}
				}

			}
			msg = "Exam Submited Successfully..";

		} catch (Exception e) {
			msg = "Contact Your Admin.";
			e.printStackTrace();

		}
		return msg;
	}

	@Override
	public Map<String, Object> getExamDtlsByStudId(int id) {
		Map<String, Object> map = null;
		try {
			List<ExamEntity> list = examRepository.getRestltByDtudentId(id);
			map = new HashMap<>();
			// collect Attended students Dtils
			Map<Student, List<AttendeQuestionDto>> studDataList = list.stream().filter(ExamEntity::isCorrectAns)
					.collect(Collectors.groupingBy(e -> e.getStudent(), Collectors.mapping(e -> {
						AttendeQuestionDto dto = new AttendeQuestionDto();
						dto.setAtendeQuestion(e.getQuestion().getQuestion());
						dto.setAtendeQuestionAns(e.getQuestion().getCorrectAsn());
						return dto;
					}, Collectors.toList())));

			List<ResultDto> qusAnsList = studDataList.entrySet().stream().map(entry -> {
				ResultDto resultDto = new ResultDto();
				resultDto.setStudId(entry.getKey().getStudId());
				resultDto.setStudName(entry.getKey().getStudName());
				resultDto.setStudEmail(entry.getKey().getStudEmail());
				resultDto.setStudMob(entry.getKey().getStudMob());
				resultDto.setStudAddr(entry.getKey().getStudAddr());
				int totalMarks = entry.getValue().size(); // Each answer is 1 mark
				resultDto.setTotalMark(totalMarks);
				resultDto.setAtendeCorrectAnsList(entry.getValue());
				return resultDto;
			}).collect(Collectors.toList());
			map.put("AttendedQstAndAns", qusAnsList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<ExamEntity> viewAll() {
		return examRepository.findAll();

	}

	@Override
	public Map<String, Object> getExamResults() {
		List<ExamEntity> list = examRepository.findAll();
		Map<String, Object> map = new HashMap<>();
		// how many peoples are attned the exam
		Long totalStud = list.stream().map(e -> e.getStudent()).distinct().count();
		map.put("totalExmAttendedCount", totalStud);
		// collect Attended students Dtils
		Map<Student, List<AttendeQuestionDto>> studDataList = list.stream().filter(ExamEntity::isCorrectAns)
				.collect(Collectors.groupingBy(e -> e.getStudent(), Collectors.mapping(e -> {
					AttendeQuestionDto dto = new AttendeQuestionDto();
					dto.setAtendeQuestion(e.getQuestion().getQuestion());
					dto.setAtendeQuestionAns(e.getQuestion().getCorrectAsn());
					return dto;
				}, Collectors.toList())));

		List<ResultDto> qusAnsList = studDataList.entrySet().stream().map(entry -> {
			ResultDto resultDto = new ResultDto();
			resultDto.setStudId(entry.getKey().getStudId());
			resultDto.setStudName(entry.getKey().getStudName());
			resultDto.setStudEmail(entry.getKey().getStudEmail());
			resultDto.setStudMob(entry.getKey().getStudMob());
			resultDto.setStudAddr(entry.getKey().getStudAddr());
			int totalMarks = entry.getValue().size(); // Each answer is 1 mark
			resultDto.setTotalMark(totalMarks);
			resultDto.setAtendeCorrectAnsList(entry.getValue());
			return resultDto;
		}).collect(Collectors.toList());
		map.put("AttendedQstAndAns", qusAnsList);

		return map;
	}

}
