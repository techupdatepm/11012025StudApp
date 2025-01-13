package com.pm.repository;

import com.pm.entity.Student;


import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	Student findByStudEmail(String studEmail);
	
}
