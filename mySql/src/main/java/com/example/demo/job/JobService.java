package com.example.demo.job;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
	@Autowired
	private JobRepository jobRepository;
	
	public List<Job> getAllJobs(){
		List<Job> jobs = new ArrayList<>();
		jobRepository.findAll().forEach(jobs::add);
		return jobs;
	}
	public void addJob(Job job) {
		jobRepository.save(job);
	}
	public Job getJob(String id) {
		if(id == null) {
			return null;
		}
		if(!jobRepository.existsById(id)){
			return null;
		}
	
		return jobRepository.findById(id).orElse(null);
	}
	public void updateJob(String id, Job job) {
		jobRepository.save(job);
	}
	public void deleteJob(String id) {
		jobRepository.deleteById(id);
	}
}
