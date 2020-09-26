package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.beans.Exam;
import com.dxc.dao.ExamRepository;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamController {
	
	@Autowired
	ExamRepository examRepository;
	
	@GetMapping(path = "exam/{id}")
	@ResponseBody
	public Exam getexam(@PathVariable("id") int id) {
		Exam exam = examRepository.findById(id).orElse(new Exam());
		return exam;
	}
	
	@GetMapping(path = "exams")
	@ResponseBody
	public List<Exam> getexams() {
		List<Exam> exams = (List<Exam>) examRepository.findAll();
		return exams;
	}
	
	@PostMapping(path = "exam")
	@ResponseBody
	public Exam save(@RequestBody Exam exam) {
		return examRepository.save(exam);
		
	}
}
