package com.etiqa.assessment.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "student_course")public class StudentCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentCourseID;
	
	private Long studentID;
	private Long courseID;
	
	public Long getStudentCourseID()
	{
	    return this.studentCourseID;
	}
	public void StudentCourseID(Long value)
	{
	     this.studentCourseID = value;
	}
	
	public Long getStudentID()
	{
	    return this.studentID;
	}
	public void setStudentID(Long value)
	{
	     this.studentID = value;
	}
	
	public Long getCourseID()
	{
	    return this.courseID;
	}
	public void setCourseID(Long value)
	{
	     this.courseID = value;
	}
}
