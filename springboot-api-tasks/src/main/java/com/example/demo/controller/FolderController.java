package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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

import com.example.demo.entity.Folder;
import com.example.demo.service.FolderService;

@RestController
@RequestMapping("/folder")
@CrossOrigin(origins="*")
public class FolderController {
	
	@Autowired
	private FolderService folderService;
	
	@GetMapping
	private List<Folder> getAll(){
		return folderService.getAll();
	}
	
	@GetMapping("/{id}")
	private Folder getById(@PathVariable long id){
		return folderService.getById(id);
	}
	
	@PostMapping
	private Folder add(@RequestBody Folder folder) {
		return folderService.addOrUpdate(folder);
	}

	@PutMapping("/{id}")
	private Folder update(@PathVariable long id, @RequestBody Folder folder) {
		folder.setId(id);
		return folderService.addOrUpdate(folder);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable long id) {
		folderService.deleteById(id);
	}

}
