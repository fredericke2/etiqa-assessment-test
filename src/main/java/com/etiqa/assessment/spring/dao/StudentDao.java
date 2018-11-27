package com.etiqa.assessment.spring.dao;

import java.util.List;
import com.etiqa.assessment.spring.model.Student;

public interface StudentDao {
	
	long save(Student student);
	Student get(long studentID);
	List<Student> list();
	List<Student> listbycourse(long courseID);
	void update(long studentID, Student student);
	void delete(long studentID);
	void registerStudentToCourse(long studentID, long courseID);
	void dropStudentToCourse(long studentID, long courseID);
}
