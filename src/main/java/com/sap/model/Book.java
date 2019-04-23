package com.sap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	
@Id
private String id;
private String title,name;

@ManyToOne
private Student issuedTo;

@ManyToOne
private Librarian issuedBy;

public Book() {}

public Book(String id, String title, String name, Student issuedTo, Librarian issuedBy) {
	super();
	this.id = id;
	this.title = title;
	this.name = name;
	this.issuedTo = issuedTo;
	this.issuedBy = issuedBy;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Student getIssuedTo() {
	return issuedTo;
}

public void setIssuedTo(Student issuedTo) {
	this.issuedTo = issuedTo;
}

public Librarian getIssuedBy() {
	return issuedBy;
}

public void setIssuedBy(Librarian issuedBy) {
	this.issuedBy = issuedBy;
}



}
