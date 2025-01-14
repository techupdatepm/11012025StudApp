package com.pm.controller;

import com.pm.entity.Student;
import com.pm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stud")
public class StudentController {

    @Autowired
    StudentService studentService;
    
    @GetMapping("/viewAll")
    public ResponseEntity<?> viewAllStudent(){
        List<Student> list=studentService.viewAllStudent();
        return ResponseEntity.ok(list); 
 
    }  
    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
    	String msg="";
    	if (Optional.ofNullable(student.getStudName()).orElse("").isEmpty() 
    	        || Optional.ofNullable(student.getStudEmail()).orElse("").isEmpty() 
    	        || Optional.ofNullable(student.getStudAddr()).orElse("").isEmpty() 
    	        || Optional.ofNullable(student.getStudMob()).orElse("").isEmpty()) {
    	    msg = "Please Provide all the Data of Student.";
    	}
else {
    	boolean status=studentService.validateStudentInfo(student);
    	if(status)
    		msg=studentService.saveStudent(student);
    	else
    		msg="Email  should not be duplicate";
    	}
        return ResponseEntity.ok(msg);

    }
    @GetMapping("/view/{studId}")
    public ResponseEntity<?> getStudentById(@PathVariable("studId") Integer studId){
        Student studDetails=studentService.getStudentById(studId);
        return ResponseEntity.ok(studDetails);

    }
 
    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
    	String msg="";
    	if (Optional.ofNullable(student.getStudName()).orElse("").isEmpty() 
    	        || Optional.ofNullable(student.getStudEmail()).orElse("").isEmpty() 
    	        || Optional.ofNullable(student.getStudAddr()).orElse("").isEmpty() 
    	        || Optional.ofNullable(student.getStudMob()).orElse("").isEmpty()) {
    	    msg = "Please Provide all the Data of Student.";
    	}else {
    	boolean status=studentService.validateStudentInfo(student);
    	if(status)
    		msg=studentService.updateStudent(student);
    	else
    		msg="Enmail should not be Duplicate";
    	}
    	return ResponseEntity.ok(msg);

    }
 
    @DeleteMapping("/delete/{studId}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("studId") Integer studId){
        String msg=studentService.deleteStudentById(studId);
        return ResponseEntity.ok(msg);

    }
}
