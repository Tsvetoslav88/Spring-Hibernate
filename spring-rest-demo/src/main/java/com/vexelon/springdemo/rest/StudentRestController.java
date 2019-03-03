package com.vexelon.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vexelon.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> theStudents;
	
	// define @PostConstruct to load the students data..only once
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Ivan", "Ivanov"));
		theStudents.add(new Student("Petar", "Petrov"));
		theStudents.add(new Student("Minko", "Minkov"));
	}
	
	
	// define endpoint for "/student"
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		
		return theStudents;
	}
	
	// define endpoint for "/students/{studentId}"
	@GetMapping("students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// check studentId agains list size
		if(studentId >= theStudents.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	// Add an exception handler using @ExaptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException exc){
		
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
}
