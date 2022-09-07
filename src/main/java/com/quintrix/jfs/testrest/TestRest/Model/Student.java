package com.quintrix.jfs.testrest.TestRest.Model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String major;
	
	public Student(int id, String firstName, String lastName, String major) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
	}
	
	public Student() {
		this.id = 0;
		this.firstName = "N/A";
		this.lastName = "N/A";
		this.major = "N/A";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", major=" + major + "]";
	}
}