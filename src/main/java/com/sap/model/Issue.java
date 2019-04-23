package com.sap.model;

public class Issue {
	
	private String bookId,studentId,librarianId;
	
	

	public Issue(String bookId, String studentId, String librarianId) {
		super();
		this.bookId = bookId;
		this.studentId = studentId;
		this.librarianId = librarianId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}
	

}
