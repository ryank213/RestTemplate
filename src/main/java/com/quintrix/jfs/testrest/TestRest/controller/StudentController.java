package com.quintrix.jfs.testrest.TestRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.quintrix.jfs.testrest.TestRest.model.Student;
import com.quintrix.jfs.testrest.TestRest.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getAllStudents();
	}
	
	@PostMapping("/students")
	public Student postStudent(@RequestBody Student student) {
		return studentService.postStudent(student);
	}
	
	@PutMapping("/students")
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}
}