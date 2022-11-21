package com.treinobrisa.crud.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.treinobrisa.crud.entity.Student;
import com.treinobrisa.crud.repository.StudentRepository;

@RestController
@CrossOrigin("http://localhost:8082/")
public class StudentController{

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public ArrayList<Student> retrieveAllStudents() {
		return (ArrayList<Student>) studentRepository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student retrieveStudent(@PathVariable long id) {
		return studentRepository.findById(id).get();
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable long id) {
		studentRepository.deleteById(id);
		return "Student Deleted " + id;
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);

	}
	
	@PutMapping("/students/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable long id) {

		Student stud = studentRepository.findById(student.getId()).get();
		stud.setNome(student.getNome());
		stud.setNumero(student.getNumero());
	
		return studentRepository.save(stud);
	}
	
}