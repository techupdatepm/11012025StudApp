package com.pm.service;

import com.pm.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> viewAllStudent();

    String saveStudent(Student student);

    Student getStudentById(Integer studId);

    String updateStudent(Student student);

    String deleteStudentById(Integer studId);

	boolean validateStudentInfo(Student student);
}
