package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Folder;
import com.example.demo.entity.repository.FolderRepository;

@Service
public class FolderService {
	@Autowired
	
	private FolderRepository folderRepository;
	
	public Folder addOrUpdate(Folder folder) {
		return folderRepository.save(folder);
	}
	
	public boolean deleteById(Long id) {
		folderRepository.deleteById(id);
		return true;
	}
	
	public List<Folder> getAll(){
		return folderRepository.findAll();
	}
	
	public Folder getById(Long id) {
		return folderRepository.findById(id).get();
	}
	
}
