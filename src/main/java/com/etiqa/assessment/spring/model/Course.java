package com.etiqa.assessment.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseID;
	private String courseTitle;
	private String courseDepartment;
	
	public Long getCourseID()
	{
	    return this.courseID;
	}
	public void setCourseID(Long value)
	{
	     this.courseID = value;
	}
	
	public String getCourseTitle()
	{
	    return this.courseTitle;
	}
	public void setCourseTitle(String value)
	{
	     this.courseTitle = value;
	}
	
	public String getCourseDepartment()
	{
	    return this.courseDepartment;
	}
	public void setCourseDepartment(String value)
	{
	     this.courseDepartment = value;
	}
}
