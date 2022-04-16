package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins="*")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	private List<Task> getAll(){
		return taskService.getAll();
	}
	
	@GetMapping("/{id}")
	private Task getById(@PathVariable long id){
		return taskService.getById(id);
	}
	
	@PostMapping
	private Task add(@RequestBody Task task) {
		return taskService.addOrUpdate(task);
	}

	@PutMapping("/{id}")
	private Task update(@PathVariable long id, @RequestBody Task task) {
		task.setId(id);
		return taskService.addOrUpdate(task);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable long id) {
		taskService.deleteById(id);
	}
}
