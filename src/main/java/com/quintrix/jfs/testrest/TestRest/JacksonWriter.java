package com.quintrix.jfs.testrest.TestRest;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix.jfs.testrest.TestRest.model.Student;

public class JacksonWriter {

  public static void main(String[] args) {
    ObjectMapper mapper = new ObjectMapper();

    Student bob = new Student(10, "Bob", "Bobson", "Math");

    try {
      // Java object to JSON file
      mapper.writeValue(new File("C:\\Users\\Ryan\\eclipse-workspace\\files\\student.json"), bob);
    } catch (IOException e) {
      e.printStackTrace();
    }
    // Java object to JSON string
    try {
      String jsonString = mapper.writeValueAsString(bob);
      System.out.println(jsonString);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
