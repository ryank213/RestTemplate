package com.quintrix.jfs.testrest.TestRest.dao;

import java.util.List;
import com.quintrix.jfs.testrest.TestRest.model.Student;

public interface StudentDao {
	public List<Student> getStudents();
	public Student postStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(int id);
}
