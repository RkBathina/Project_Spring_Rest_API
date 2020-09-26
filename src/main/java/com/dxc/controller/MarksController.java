package com.dxc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.beans.Marks;
import com.dxc.dao.MarksRepository;

@RestController
public class MarksController {
	
	@Autowired
	MarksRepository marksRepository;
	
	@GetMapping(path = "marks")
	@ResponseBody
	public List<Marks> getMarks(){
		List<Marks> marks = (List<Marks>) marksRepository.findAll();
		return marks;
	}
	
	@GetMapping(path = "mark/{stid}")
	@ResponseBody
	public Marks getMark(@PathVariable("stid") int stid) {
		Marks mark = marksRepository.findById(stid).orElse(new Marks());
		return mark;
	}
	
	@PostMapping(path = "mark")
	@ResponseBody
	public Marks save(@RequestBody Marks mark) {
		return marksRepository.save(mark);	
	}
	
	@PutMapping(path = "mark")
	@ResponseBody
	public ResponseEntity<Marks> update(@RequestBody Marks mark) {
		Optional<Marks> markexist = marksRepository.findById(mark.getStid());
		if(!markexist.isPresent())
			return ResponseEntity.notFound().build();
		marksRepository.save(mark);
		return ResponseEntity.notFound().build();
	}

}
