package com.etiqa.assessment.spring.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentID;
	private String firstname;
	private String lastname;
	private String classification;
	
	public Long getStudentID()
	{
	    return this.studentID;
	}
	public void setStudentID(Long value)
	{
	     this.studentID = value;
	}
	
	public String getFirstname()
	{
	    return this.firstname;
	}
	public void setFirstname(String value)
	{
	     this.firstname = value;
	}
	
	public String getLastname()
	{
	    return this.lastname;
	}
	public void setLastname(String value)
	{
	     this.lastname = value;
	}
	
	public String getClassification()
	{
	    return this.classification;
	}
	public void setClassification(String value)
	{
	     this.classification = value;
	}

}
		