package com.etiqa.assessment.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etiqa.assessment.spring.model.Course;
import com.etiqa.assessment.spring.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	/*---Add new course---*/
	@PostMapping("/course")
	public ResponseEntity<?> save(@RequestBody Course course) {
		long courseID = courseService.save(course);
		return ResponseEntity.ok().body("New Course has been saved with Course ID:" + courseID);
	}

	/*---Get a course by id---*/
	@GetMapping("/course/{courseID}")
	public ResponseEntity<Course> get(@PathVariable("courseID") long courseID) {
		Course course = courseService.get(courseID);
		return ResponseEntity.ok().body(course);
	}

	/*---get all courses---*/
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> list() {
		List<Course> course = courseService.list();
		return ResponseEntity.ok().body(course);
	}

	/*---Update a course by id---*/
	@PutMapping("/course/{courseID}")
	public ResponseEntity<?> update(@PathVariable("courseID") long courseID, @RequestBody Course course) {
		courseService.update(courseID, course);
		return ResponseEntity.ok().body("Course has been updated successfully.");
	}

	/*---Delete a course by id---*/
	@DeleteMapping("/course/{courseID}")
	public ResponseEntity<?> delete(@PathVariable("courseID") long courseID) {
		courseService.delete(courseID);
		return ResponseEntity.ok().body("Course has been deleted successfully.");
	}
}
