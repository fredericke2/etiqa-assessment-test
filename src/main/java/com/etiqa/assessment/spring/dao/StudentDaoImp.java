package com.etiqa.assessment.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.etiqa.assessment.spring.model.Student;
import com.etiqa.assessment.spring.model.StudentCourse;

@Repository
public class StudentDaoImp implements StudentDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Student student) {
		sessionFactory.getCurrentSession().save(student);
	   return student.getStudentID();
	}
	
	public void registerStudentToCourse(long studentID, long courseID) {
		StudentCourse studentcourse = new StudentCourse();
		studentcourse.setStudentID(studentID);
		studentcourse.setCourseID(courseID);
		sessionFactory.getCurrentSession().save(studentcourse);
	}

	@Override
	public Student get(long studentID) {
		return sessionFactory.getCurrentSession().get(Student.class, studentID);
	}

	@Override
	public List<Student> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.select(root);
		Query<Student> query = session.createQuery(cq);
		return query.getResultList();
	}
	
	public List<Student> listbycourse(long courseID) {	
		Session session = sessionFactory.getCurrentSession();
		SQLQuery<Student> query = session.createSQLQuery("SELECT s.studentID, firstname, lastname, classification FROM student s, student_course sc where s.studentID = sc.studentID and sc.courseID = " + courseID );
		return query.getResultList();
	}

	@Override
	public void update(long studentID, Student student) {
		Session session = sessionFactory.getCurrentSession();
		Student student2 = session.byId(Student.class).load(studentID);
		student2.setFirstname(student.getFirstname());
		student2.setLastname(student.getLastname());
		student2.setClassification(student.getClassification());
		session.flush();
	}

	@Override
	public void delete(long studentID) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.byId(Student.class).load(studentID);
		session.delete(student);
	}
	
	public void dropStudentToCourse(long studentID, long courseID) {
		Session session = sessionFactory.getCurrentSession();
		
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<StudentCourse> cq = cb.createQuery(StudentCourse.class);
		Root<StudentCourse> root = cq.from(StudentCourse.class);
		cq.where(cb.equal(root.get("courseID"),courseID));
		cq.where(cb.equal(root.get("studentID"),studentID));
		
		Query<StudentCourse> query = session.createQuery(cq);
        final List<StudentCourse> results = query.getResultList();
        
		StudentCourse studentcourse = results.get(0);
		session.delete(studentcourse);
	}
}
