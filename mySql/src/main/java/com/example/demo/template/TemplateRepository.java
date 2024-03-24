package com.example.demo.template;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Template,Long>{
	List<Template> findByName(String name);
	boolean existsByName(String name);
	void deleteByName(String name);
}
