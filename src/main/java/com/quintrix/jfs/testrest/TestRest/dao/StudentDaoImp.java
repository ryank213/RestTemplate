package com.quintrix.jfs.testrest.TestRest.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix.jfs.testrest.TestRest.model.Student;

@Component
public class StudentDaoImp implements StudentDao {

  @Autowired
  RestTemplate restTemplate;

  String url = "http://localhost:8080/students";

  @Override
  public List<Student> getStudents() {
    try {
      ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
      System.out.println(response.getStatusCode() + response.getBody());
      ObjectMapper objectMapper = new ObjectMapper();
      List<Student> students =
          objectMapper.readValue(response.getBody(), new TypeReference<List<Student>>() {});
      return students;
    } catch (RestClientException | JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Student postStudent(Student student) {
    HttpEntity<Student> http = new HttpEntity<Student>(student);
    return restTemplate.postForObject(url, http, Student.class);
  }

  @Override
  public void updateStudent(Student student) {
    HttpEntity<Student> http = new HttpEntity<Student>(student);
    restTemplate.put(url, http);
  }

  @Override
  public void deleteStudent(int id) {
    restTemplate.delete(url + "/" + id);
  }

}
