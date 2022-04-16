package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Folder;
import com.example.demo.entity.Task;
import com.example.demo.entity.repository.FolderRepository;

@SpringBootApplication
public class SpringbootApiTasksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiTasksApplication.class, args);
	}

	@Autowired
	private FolderRepository folderRepository;
	
	public void run(String... arg) throws Exception {
		
		Folder folder = new Folder("Carpeta 1");
		
		Task t1 = new Task("tarea 1");
		Task t2 = new Task("tarea 2");
		Task t3 = new Task("tarea 3");
		
		folder.getTasks().add(t1);
		folder.getTasks().add(t2);
		folder.getTasks().add(t3);
		
		this.folderRepository.save(folder);
		
	}
}
