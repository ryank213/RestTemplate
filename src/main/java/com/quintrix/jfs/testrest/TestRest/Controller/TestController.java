package com.quintrix.jfs.testrest.TestRest.Controller;

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
import com.quintrix.jfs.testrest.TestRest.Model.Student;

@RestController
public class TestController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/students")
	public String home() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/students", String.class);
		return response.getBody() + "\n" + response.getStatusCode() + "\n" + response.getStatusCodeValue();
	}
	
	@PostMapping("/students")
	public String postStudent(@RequestBody Student student) {
		HttpEntity<Student> request = new HttpEntity<Student>(student);
		return restTemplate.postForObject("http://localhost:8080/students", request, String.class);
	}
	
	@PutMapping("/students")
	public void updateStudent(@RequestBody Student student) {
		HttpEntity<Student> request = new HttpEntity<Student>(student);
		restTemplate.put("http://localhost:8080/students", request);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable int id) {
		restTemplate.delete("http://localhost:8080/students/" + id);
	}
}
