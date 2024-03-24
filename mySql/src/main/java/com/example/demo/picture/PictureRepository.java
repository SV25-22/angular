package com.example.demo.picture;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture,Long>{
	List<Picture> findByRelPath(String relPath);
	boolean existsByRelPath(String relPath);
	void deleteByRelPath(String relPath);
	
}
