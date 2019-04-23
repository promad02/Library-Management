package com.sap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.model.LibrarianRepo;

import com.sap.model.Librarian;

@Service
public class LibrarianService {
	
	@Autowired
	private LibrarianRepo repo;
	
	public List<Librarian> getAllLibrarians(){
		
		List<Librarian> students = new ArrayList<>();
		repo.findAll()
		.forEach(students::add);
		return students;
	}
	
	public Librarian getLibrarianById(String id) {
		return repo.findById(id).get();
	}
	
	public String addLibrarian(Librarian student) {
		repo.save(student);
		return "Success";
	}
	
	public void deleteLibrarian(String id) {
		repo.deleteById(id);
	}

}
