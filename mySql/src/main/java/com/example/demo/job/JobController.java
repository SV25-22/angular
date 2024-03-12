package com.example.demo.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class JobController {
	@Autowired
	private JobService jobService;
	
	@GetMapping("/jobs")
	public List<Job> getAllJobs(){
		return jobService.getAllJobs();
	}
	@GetMapping("/jobs/{id}")
	public Job getJob(@PathVariable("id") String id) {
		return jobService.getJob(id);
	}
	@PostMapping("/jobs")
	public void addJob(@RequestBody Job job) {
		jobService.addJob(job);
	}
	@PutMapping("/jobs/{id}")
	public void updateJob(@RequestBody Job job,@PathVariable("id") String id) {
		jobService.updateJob(id, job);
	}
	@DeleteMapping("/jobs/{id}")
	public void deleteJob(@PathVariable("id") String id) {
		jobService.deleteJob(id);
	}
}
