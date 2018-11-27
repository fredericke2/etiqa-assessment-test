package com.etiqa.assessment.spring.service;

import java.util.List;
import com.etiqa.assessment.spring.model.Student;

public interface StudentService {
	long save(Student student);
	Student get(long studentID);
	List<Student> list();
	void update(long studentID, Student student);
	void delete(long studentID);
	void registerStudentToCourse(long studentID, long courseID);
	void drop(long studentID, long courseID);
	List<Student> listbycourse(long courseID);
}
