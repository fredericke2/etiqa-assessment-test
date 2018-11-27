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

import com.etiqa.assessment.spring.model.Student;
import com.etiqa.assessment.spring.service.StudentService;
import com.etiqa.assessment.spring.model.StudentCourse;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	/*---Add new student---*/
	@PostMapping("/student")
	public ResponseEntity<?> save(@RequestBody Student student) {
		long studentID = studentService.save(student);
		return ResponseEntity.ok().body("New Student has been saved with Student ID:" + studentID);
	}
	
	/*---Register student to a course---*/
	@PostMapping("/register")
	public ResponseEntity<?> registerStudentToCourse(@RequestBody StudentCourse studentcourse) {
		studentService.registerStudentToCourse(studentcourse.getStudentID(), studentcourse.getCourseID());
		return ResponseEntity.ok().body("Student " +  studentcourse.getStudentID() + " has been enrolled successfully");
	}

	/*---Get a student by id---*/
	@GetMapping("/student/{studentID}")
	public ResponseEntity<Student> get(@PathVariable("studentID") long studentID) {
		Student student = studentService.get(studentID);
		return ResponseEntity.ok().body(student);
	}

	/*---get all students---*/
	@GetMapping("/students")
	public ResponseEntity<List<Student>> list() {
		List<Student> student = studentService.list();
		return ResponseEntity.ok().body(student);
	}

	/*---Update a student by id---*/
	@PutMapping("/student/{studentID}")
	public ResponseEntity<?> update(@PathVariable("studentID") long studentID, @RequestBody Student student) {
		studentService.update(studentID, student);
		return ResponseEntity.ok().body("Student has been updated successfully.");
	}

	/*---Delete a student by id---*/
	@DeleteMapping("/student/{studentID}")
	public ResponseEntity<?> delete(@PathVariable("studentID") long studentID) {
		studentService.delete(studentID);
		return ResponseEntity.ok().body("Student has been deleted successfully.");
	}
	
	/*---Drop a student from the course---*/
	@PostMapping("/drop")
	public ResponseEntity<?> drop(@RequestBody StudentCourse studentcourse) {
		studentService.drop(studentcourse.getStudentID(), studentcourse.getCourseID());
		return ResponseEntity.ok().body("Student has been dropped successfully.");
	}
	
	/*---get all students---*/
	@GetMapping("/listbycourse/{courseID}")
	public ResponseEntity<List<Student>> listbycourse(@PathVariable("courseID") long courseID) {
		List<Student> student = studentService.listbycourse(courseID);
		return ResponseEntity.ok().body(student);
	}
}
