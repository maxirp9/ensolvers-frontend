package com.example.demo.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long>{

}
