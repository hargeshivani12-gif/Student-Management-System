package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//POJO class ---> Plain Old Java Object but this is not pojo class this is entity class
//info about student which stored in database 
//this class managed by spring data jpa
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Table(name = "Student_info")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Pattern(
//			regexp = "Student",
//			message = "Student must be from science background"
//			)
	
	//@Column(name = "StudentName")
	private String name;
	
	//@Column(name = "Studentage")
	private Integer age;
	
	//@Column(name = "StudentEmail")
	private String email;
	
	//@Column(name = "StudentRollno")
	private Integer rollno;
	
	//@Column(name = "StudentSubject")
	private String subject;
	
	private boolean deleted;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Long getId() {
		return id;
	}
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
	public void setId(Long id) {
		this.id = id;
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
//@Entity ---> mapped Student class in database table 
//@id ---> primary key in database 