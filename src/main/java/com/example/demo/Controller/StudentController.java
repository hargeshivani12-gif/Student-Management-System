package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import com.example.demo.dto.createStudentRequestdto;
import com.example.demo.dto.createStudentResponsedto;
import com.example.demo.dto.updateStudentRequestdto;
import com.example.demo.dto.updateStudentResponsedto;

import jakarta.validation.Valid;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/students")
public class StudentController
{
	
	private StudentService studentService;
	//constructor injection no need to use @Autowired Annotation 
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	//Create Student ---> POST---> localhost:9090/api/students
	@PostMapping
	public ResponseEntity<createStudentResponsedto> createStudent
	(@Valid @RequestBody createStudentRequestdto studentRequestdto)
	{
		//student.setDeleted(false);
		createStudentResponsedto createdStudent = 
				studentService.createStudent(studentRequestdto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(createdStudent);
	}
	
	//read one student
	//localhost:9090/api/students/1
	@GetMapping("/{id}")
	public ResponseEntity<createStudentResponsedto> getStudent(@PathVariable Long id)
	{
		
		createStudentResponsedto StudentRes = studentService.getStudent(id);
		return ResponseEntity.ok(StudentRes);
		
	}
	
	//getAllstudent
	//localhost:9090/api/students
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent()
	{
		List<Student> StudentList = studentService.getAllStudent();
		return ResponseEntity.ok(StudentList);
		
	}
	//update student
	//http://localhost:9090/api/students/1
	@PutMapping("/{id}")
	public ResponseEntity<updateStudentResponsedto> updateStudent(@PathVariable Long id,
			@RequestBody updateStudentRequestdto updateStudentRequestdto)
	{
		updateStudentResponsedto studentRes = studentService.updateStudent(id,updateStudentRequestdto);
		return ResponseEntity.ok(studentRes);
		
	}
	
	//delete student
	//http://localhost:9090/api/students/delete/7
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id)
	{
		studentService.deleteStudent(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	//delete all student
	//http://localhost:9090/api/students
	@DeleteMapping
	public ResponseEntity<String> deleteAllStudent()
	{
		studentService.deleteAllStudent();
		return ResponseEntity.ok("deleted all records successfully");
		
	}
	//http://localhost:9090/api/students/delete-soft/1
	@PatchMapping("/delete-soft/{id}")
	public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id)
	{
		studentService.deleteStudentSoftly(id);
		
		return ResponseEntity.noContent().build();
		
		
	}

}

//@RequestBody ---> used to read the data sent by the client in the HTTP request body and convert it into a Java object.
//meaning --- Take the JSON data from the request body and convert it into an Java object."