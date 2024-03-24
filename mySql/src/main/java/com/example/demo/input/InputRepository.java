package com.example.demo.input;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<Input,Long> {
	List<Input> findByLabel(String label);
	boolean existsByLabel(String label);
	void deleteByLabel(String label);
}
