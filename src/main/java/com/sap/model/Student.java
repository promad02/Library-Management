package com.sap.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
@Id
private String sId;
private String name;


public Student() {}
public Student(String sId, String name) {
	super();
	this.sId = sId;
	this.name = name;
}
public String getsId() {
	return sId;
}
public void setsId(String sId) {
	this.sId = sId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
