package com.sap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sap.model.Book;
import com.sap.model.Issue;
import com.sap.model.Librarian;
import com.sap.model.Student;
import com.sap.service.BookService;
import com.sap.service.LibrarianService;
import com.sap.service.StudentService;

@RestController
public class LibraryController {

	@Autowired
	private BookService bookService;

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private LibrarianService librarianService;
	
	@GetMapping("/books/{id}/isAvailable")
	public Boolean isAvailable(@PathVariable String id){
		return !bookService.isIssued(id);
		}
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
		}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
		}
	
	@GetMapping("/librarians")
	public List<Librarian> getAllLibrarians(){
		return librarianService.getAllLibrarians();
		}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable String id){
		return bookService.getBookById(id);
		}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable String id){
		return studentService.getStudentById(id);
		}
	
	@GetMapping("/librarians/{id}")
	public Librarian getLibrarian(@PathVariable String id){
		return librarianService.getLibrarianById(id);
		}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable String bookId) {
		bookService.deleteBook(bookId);
	}
	
	@DeleteMapping("/students/{studentId}")
	public void deleteStudent(@PathVariable String studentId) {
		librarianService.deleteLibrarian(studentId);
	}
	
	@DeleteMapping("/librarians/{librarianId}")
	public void deleteLibrarian(@PathVariable String librarianId) {
		librarianService.deleteLibrarian(librarianId);
	}
	
	@PostMapping("/students")
	public String addStudent(@RequestBody Student student){
		return studentService.addStudent(student);
	}
	
	@PostMapping("/librarians")
	public String addLibrarian(@RequestBody Librarian librarian){
		return librarianService.addLibrarian(librarian);
	}
	
	@PostMapping("/books")
	public String addBook(@RequestBody Book book){
		return bookService.addBook(book);
	}
	
	@PutMapping("/books/issue")
	public String issueBook(@RequestBody Issue issue) {

		String bookId = issue.getBookId();
		if(!bookService.isIssued(bookId)) {
			String librarianId = issue.getLibrarianId();
			String studentId = issue.getStudentId();
			
			Book book = bookService.getBookById(bookId);
			
			book.setIssuedBy(new Librarian(librarianId,null));
			book.setIssuedTo(new Student(studentId,null));
			
			bookService.updateBook(book);
			
			return "Success";
		}
		else
			return "Book not available!!";
	}
	
	@PutMapping("/books/return")
	public String returnBook(@RequestBody Issue issue) {

		String bookId = issue.getBookId();
		if(bookService.isIssued(bookId)) {
			
			Book book = bookService.getBookById(bookId);
			
			book.setIssuedBy(null);
			book.setIssuedTo(null);
			
			bookService.updateBook(book);
			
			return "Success";
		}
		else
			return "Book not issued!!";
	}
	
}
