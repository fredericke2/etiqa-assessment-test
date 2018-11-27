package com.etiqa.assessment.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etiqa.assessment.spring.dao.CourseDao;
import com.etiqa.assessment.spring.model.Course;

@Service
@Transactional(readOnly = true)
public class CourseServiceImp implements CourseService {

	@Autowired
	private CourseDao courseDao;

	@Transactional
	@Override
	public long save(Course course) {
		return courseDao.save(course);
	}

	@Override
	public Course get(long courseID) {
		return courseDao.get(courseID);
	}

	@Override
	public List<Course> list() {
		return courseDao.list();
	}

	@Transactional
	@Override
	public void update(long courseID, Course course) {
		courseDao.update(courseID, course);
	}

	@Transactional
	@Override
	public void delete(long courseID) {
		courseDao.delete(courseID);
	}
}
