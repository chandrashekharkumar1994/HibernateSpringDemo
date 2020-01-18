package com.landq.bean;

import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="EMPLOYEE")
public class Employee {  
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;    
private String name;    
private float salary;    
private String designation; 
/*private String file_name;
    
public void setFileName(String file_name){
	this.file_name=file_name;
}
public String getFileName(){
	return file_name;
}*/
public int getId(){    
	//System.out.println("In getId getter method");
    return id;    
}    
public void setId(int id) {    
	//System.out.println("In setId setter method");
    this.id = id;    
}

public String getName() {    
    return name;    
}    
public void setName(String name) {    
    this.name = name;    
}    
public float getSalary() {    
    return salary;    
}    
public void setSalary(float salary) {    
    this.salary = salary;    
}    
public String getDesignation() {    
    return designation;    
}    
public void setDesignation(String designation) {    
    this.designation = designation;    
}    
    
}    