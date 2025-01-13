package com.pm.service;

import com.pm.entity.Student;
import com.pm.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> viewAllStudent() {
        List<Student> list=null;
        try{
           list= studentRepository.findAll();
           System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String saveStudent(Student student) {
        String msg="";
        try{
            Student entity=studentRepository.save(student);
            if(entity !=null)
                msg="Student has been added successfully";
            else
                msg="Try again";
        }catch (Exception e){
            msg= e.getMessage();
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public Student getStudentById(Integer studId) {
        Student details=null;
        try{
            Optional<Student> optData=studentRepository.findById(studId);
            if(optData!=null){
                details=optData.get();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return details;
    }

    @Override
    public String updateStudent(Student student) {
        String msg="";
        try{
            Student entity=studentRepository.save(student);
            if(entity !=null)
                msg="Student has been updated successfully";
            else
                msg="Try again";
        }catch (Exception e){
            msg= e.getMessage();
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String deleteStudentById(Integer studId) {
        String msg="";

        try{
            Student details=null;
            Optional<Student> optData=studentRepository.findById(studId);
            if(optData!=null){
                details=optData.get();
                studentRepository.deleteById(details.getStudId());
                msg="Student has been remove successfully ";
            }else
                msg="Student not found";
        }catch (Exception e){
            msg="Student not found";
            e.printStackTrace();
        }
        return msg;
    }

	@Override
	public boolean validateStudentInfo(Student student) {
		boolean status=false;
		try {
			Student studDtls=studentRepository.findByStudEmail(student.getStudEmail());
			//save
			if(student.getStudId() ==null) {
				if(studDtls !=null) 
					status=false;
				else
					status=true;
			}else {
				//update
				if(student.getStudId()==studDtls.getStudId())
					status=true;
				else
					status=false;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			}
		return status;
	}
}
