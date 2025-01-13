package com.pm.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "stud_mgm")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer studId;
    @Column(name = "name")
    private String studName;

    @Column(name = "email")
    private String studEmail;

    @Column(name = "address")
    private String studAddr;
    @Column(name = "mob")
    private String studMob;
    
    @JsonIgnore
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExamEntity> resultList;
    

    public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudEmail() {
        return studEmail;
    }

    public void setStudEmail(String studEmail) {
        this.studEmail = studEmail;
    }

    public String getStudAddr() {
        return studAddr;
    }

    public void setStudAddr(String studAddr) {
        this.studAddr = studAddr;
    }

    public String getStudMob() {
        return studMob;
    }

    public void setStudMob(String studMob) {
        this.studMob = studMob;
    }

	public List<ExamEntity> getResultList() {
		return resultList;
	}

	public void setResultList(List<ExamEntity> resultList) {
		this.resultList = resultList;
	}

	
    
    
}
