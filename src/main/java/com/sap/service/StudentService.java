package com.sap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.model.StudentRepo;

import com.sap.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	public List<Student> getAllStudents(){
		
		List<Student> students = new ArrayList<>();
		repo.findAll()
		.forEach(students::add);
		return students;
	}
	
	public Student getStudentById(String id) {
		return repo.findById(id).get();
	}
	
	public String addStudent(Student student) {
		repo.save(student);
		return "Success";
	}
	
	public void deleteStudent(String id) {
		repo.deleteById(id);
	}

}
