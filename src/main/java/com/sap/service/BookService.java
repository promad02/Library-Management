package com.sap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.model.BookRepo;

import com.sap.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepo repo;
	
	public List<Book> getAllBooks(){
		
		List<Book> students = new ArrayList<>();
		repo.findAll()
		.forEach(students::add);
		return students;
	}
	public Boolean isIssued(String id) {
		Book book=this.getBookById(id);
		return (!(book.getIssuedTo() == null));
	}
	
	public Book getBookById(String id) {
		return repo.findById(id).get();
	}
	
	public String addBook(Book book) {
		repo.save(book);
		return "Success";
	}
	
	public void deleteBook(String id) {
		repo.deleteById(id);
	}
	
	public void updateBook(Book book) {
		repo.save(book);
	}

}
