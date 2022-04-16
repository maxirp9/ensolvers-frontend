package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.entity.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	
	private TaskRepository taskRepository;
	
	public Task addOrUpdate(Task task) {
		return taskRepository.save(task);
	}
	
	public boolean deleteById(Long id) {
		taskRepository.deleteById(id);
		return true;
	}
	
	public List<Task> getAll(){
		return taskRepository.findAll();
	}
	
	public Task getById(Long id) {
		return taskRepository.findById(id).get();
	}

}
