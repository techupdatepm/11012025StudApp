package com.pm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pm.entity.ExamEntity;

public interface ExamRepository extends JpaRepository<ExamEntity, Integer> {

	@Query("from ExamEntity where student.studId=:id")
	List<ExamEntity> getRestltByDtudentId(@Param("id") int id);
}
