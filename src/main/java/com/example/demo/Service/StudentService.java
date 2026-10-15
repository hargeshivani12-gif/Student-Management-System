package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Exception.DuplicateResourceException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.dto.createStudentRequestdto;
import com.example.demo.dto.createStudentResponsedto;
import com.example.demo.dto.updateStudentRequestdto;
import com.example.demo.dto.updateStudentResponsedto;

import jakarta.validation.constraints.Email;
//business logic
@Service
public class StudentService 
{
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public createStudentResponsedto createStudent
	(createStudentRequestdto studentRequestdto) 
	{
		Student student= mapToEntity(studentRequestdto);
		if (emailExists(student)) 
		{
			throw new DuplicateResourceException("Student with email "+student.getEmail()+" already exists");
		}
		Student studenRes =  studentRepository.save(student);
		return mapToDto(studenRes);
	}

	private boolean emailExists(Student student)
	{
		// TODO Auto-generated method stub
		return studentRepository.existsByEmail(student.getEmail());
	}

	//select * from student where id=1 and deleted=false
	public createStudentResponsedto getStudent(Long id)
	{
		//if null then NullPointerException  occurs the handle in ResourceNotFoundException class
		Student studentResponse = studentRepository
				.findById(id)
				.orElseThrow(
						() ->new  ResourceNotFoundException("Student with id "+id+" not found"));
		//if student found return response 
		return mapToDto(studentResponse);

	}

	//Select * from student where deleted=false
	public List<Student> getAllStudent()
	{
		List<Student> studentList = studentRepository.findByDeletedIsFalse();
		return studentList;
	}

	public updateStudentResponsedto  updateStudent(Long id,updateStudentRequestdto updateStudentRequestdto) 
	{
		
		Student studentRes = studentRepository.findByIdAndDeletedIsFalse(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("Student with id "+id+" not found"));
		
//		Student studentToSave = studentRes;
		studentRes.setName(updateStudentRequestdto.getName());
		studentRes.setRollno(updateStudentRequestdto.getRollno());
		//studentToSave.setId(studenrReq.getId());
		studentRes.setAge(updateStudentRequestdto.getAge());
		//studentToSave.setEmail(updateStudentRequestdto.getEmail());
		studentRes.setSubject(updateStudentRequestdto.getSubject());
		studentRes.setDeleted(false);
		studentRes.setUpdatedAt(LocalDateTime.now());
		//studentToSave.setCreatedAt(LocalDateTime.now());
		Student updatedStudent = studentRepository.save(studentRes);
		//return Optional.of(updatedStudent);
		
		return mapToUpdateDto(updatedStudent);
		
	}

	
	private updateStudentResponsedto mapToUpdateDto(Student updatedStudent)
	{
	    updateStudentResponsedto responseDto = new updateStudentResponsedto();

	    responseDto.setName(updatedStudent.getName());
	    responseDto.setAge(updatedStudent.getAge());
	    responseDto.setRollno(updatedStudent.getRollno());
	    responseDto.setSubject(updatedStudent.getSubject());
	    responseDto.setEmail(updatedStudent.getEmail());

	    responseDto.setMessage("student updated successfully.....");

	    responseDto.setCreatedAt(updatedStudent.getCreatedAt());
	    responseDto.setUpdatedAt(updatedStudent.getUpdatedAt());

	    return responseDto;
	}

	public void deleteAllStudent()
	{
		
		studentRepository.deleteAll();
		
	}

	//delete student
	public void deleteStudent(Long id) {

	    Student  studentToBeDeleted = studentRepository
	    		.findById(id)
	    		.orElseThrow(
	    		()-> new ResourceNotFoundException("Student with id "+id+" not found"));
		studentRepository.delete(studentToBeDeleted);
		
	}

	public void deleteStudentSoftly(Long id) 
	{
		//get
		Student exstingStudent = studentRepository
				.findByIdAndDeletedIsFalse(id)
				.orElseThrow(()
						-> new ResourceNotFoundException("Student with id "+id+" not found"));
		//set delete =1
		exstingStudent.setDeleted(true);
		//save
		studentRepository.save(exstingStudent);

	}

	private createStudentResponsedto mapToDto(Student studenRes) 
	{
		createStudentResponsedto Responsedto = new createStudentResponsedto();
		Responsedto.setName(studenRes.getName());
		Responsedto.setAge(studenRes.getAge());
		Responsedto.setRollno(studenRes.getRollno());
		Responsedto.setSubject(studenRes.getSubject());
		Responsedto.setEmail(studenRes.getEmail());
		Responsedto.setMessage("student Saved successfully.....");
		Responsedto.setCreatedAt(studenRes.getCreatedAt());
		Responsedto.setUpdatedAt(studenRes.getUpdatedAt());
		return Responsedto;
	}

	private Student mapToEntity(createStudentRequestdto studentRequestdto) {
		Student student  = new Student();
		student.setName(studentRequestdto.getName());
		student.setAge(studentRequestdto.getAge());
		student.setEmail(studentRequestdto.getEmail());
		student.setSubject(studentRequestdto.getSubject());
		student.setRollno(studentRequestdto.getRollno());
		student.setCreatedAt(LocalDateTime.now());
		student.setUpdatedAt(LocalDateTime.now());
	
		student.setDeleted(false);
		return student;
	}
	

}


//1.End point to listen karna (/api/students POST)
//2.Business logic
//3.interact with db to store data 
//4.response back to client