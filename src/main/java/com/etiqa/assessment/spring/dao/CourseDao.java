package com.etiqa.assessment.spring.dao;

import java.util.List;
import com.etiqa.assessment.spring.model.Course;

public interface CourseDao {

	long save(Course course);
	Course get(long courseID);
	List<Course> list();
	void update(long courseID, Course course);
	void delete(long courseID);
}
