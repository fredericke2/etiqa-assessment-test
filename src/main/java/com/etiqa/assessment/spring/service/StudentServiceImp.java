package com.etiqa.assessment.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etiqa.assessment.spring.dao.StudentDao;
import com.etiqa.assessment.spring.model.Student;

@Service
@Transactional(readOnly = true)
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Transactional
	@Override
	public long save(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Student get(long studentID) {
		return studentDao.get(studentID);
	}

	@Override
	public List<Student> list() {
		return studentDao.list();
	}

	@Transactional
	@Override
	public void update(long studentID, Student student) {
		studentDao.update(studentID, student);
	}

	@Transactional
	@Override
	public void delete(long studentID) {
		studentDao.delete(studentID);
	}
	
	@Transactional
	@Override
	public void registerStudentToCourse(long studentID, long courseID) {
		studentDao.registerStudentToCourse(studentID, courseID);
	}
	
	@Transactional
	@Override
	public void drop(long studentID, long courseID) {
		studentDao.dropStudentToCourse(studentID, courseID);
	}
	
	@Transactional
	public List<Student> listbycourse(long courseID) {
		return studentDao.listbycourse(courseID);
	}
}
