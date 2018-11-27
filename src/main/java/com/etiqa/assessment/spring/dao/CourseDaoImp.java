package com.etiqa.assessment.spring.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.etiqa.assessment.spring.model.Course;

@Repository
public class CourseDaoImp implements CourseDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Course course) {
		sessionFactory.getCurrentSession().save(course);
	   return course.getCourseID();
	}

	@Override
	public Course get(long courseID) {
		return sessionFactory.getCurrentSession().get(Course.class, courseID);
	}

	@Override
	public List<Course> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> root = cq.from(Course.class);
		cq.select(root);
		Query<Course> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long courseID, Course course) {
		Session session = sessionFactory.getCurrentSession();
		Course course2 = session.byId(Course.class).load(courseID);
		course2.setCourseTitle(course.getCourseTitle());
		course2.setCourseDepartment(course.getCourseDepartment());
		session.flush();
	}

	@Override
	public void delete(long courseID) {
		Session session = sessionFactory.getCurrentSession();
		Course student = session.byId(Course.class).load(courseID);
		session.delete(student);
	}
}
