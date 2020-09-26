package com.dxc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.beans.Student1;
import com.dxc.dao.StudentRepository;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping(path = "student/{id}")
	@ResponseBody
	public Student1 getStudent(@PathVariable("id") int id) {
		
		Student1 student = studentRepository.findById(id).orElse(new Student1());
		return student;
	}
	
	@GetMapping(path = "students")
	@ResponseBody
	public List<Student1> getStudents(){
		
		List<Student1> students = (List<Student1>) studentRepository.findAll();
		return students;
	}
	
	@PostMapping(path = "student")
	@ResponseBody
	public Student1 save(@RequestBody Student1 student) {
		return studentRepository.save(student);
	}
	
	/*@PutMapping(path = "student")
	@ResponseBody
	public Student1 update(@RequestBody Student1 student) {
		return ((StudentController) studentRepository).update(student);
	}*/
	
	/*@PutMapping(path = "student")
	@ResponseBody
	public ResponseEntity<Student1> updatestudent(@RequestBody Student1 student, @PathVariable int id){
		Optional<Student1> students = studentRepository.findById(id);
		if(!students.isPresent())
			return ResponseEntity.notFound().build();
		student.setId(id);
		studentRepository.save(student);
		return ResponseEntity.notFound().build();
	}*/
	
	@PutMapping(path = "student")
	@ResponseBody
	public ResponseEntity<Student1> update(@RequestBody Student1 student) {
		Optional<Student1> studentexist = studentRepository.findById(student.getId());
		if(!studentexist.isPresent())
			return ResponseEntity.notFound().build();
		studentRepository.save(student);
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping(path = "student/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") int id) {
		studentRepository.deleteById(id);
	}
}
