package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class createStudentRequestdto {

	@NotBlank(message = "Name cannot be null/Empty or Blank")
	@Size(min = 2,max = 50, message = "Student name must be within 2 to 50 character long")
	private String name;
	
	@NotNull(message = "age is required")
	@Min(value =18,message = "student  must be atleast 18")
	private Integer age;
	
	@NotBlank(message = "Student email cannot be Blank")
	@Email()
	private String email;
	
	@NotNull(message = "student rollno is required")
	private Integer rollno;
	
	@NotBlank(message = "subject is required")
	private String subject;
	
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	public Integer getRollno() {
		return rollno;
	}
	public String getSubject() {
		return subject;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
