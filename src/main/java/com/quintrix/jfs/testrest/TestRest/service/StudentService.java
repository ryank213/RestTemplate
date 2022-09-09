package com.quintrix.jfs.testrest.TestRest.service;

import java.util.List;
import com.quintrix.jfs.testrest.TestRest.model.Student;

public interface StudentService {
	public List<Student> getAllStudents();
	public Student postStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(int id);
}
