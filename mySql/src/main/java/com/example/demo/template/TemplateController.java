package com.example.demo.template;

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
public class TemplateController {
	@Autowired
	private TemplateService templateService;
	
	@GetMapping("/")
	public String greeting() {
		return "Hi";
	}
	@GetMapping("/hello")
	public String helloMessage() {
		return "Hello";
	}

	
	@GetMapping("/templates")
	public List<Template> getAllTemplates(){
		return templateService.getAllTemplates();
	}
	@GetMapping("/templates/{name}")
	public List<Template> getTemplate(@PathVariable("name") String name) {
		return templateService.getTemplate(name);
	}
	@PostMapping("/templates")
	public void addTemplate(@RequestBody Template template) {
		templateService.addTemplate(template);
	}
	@PutMapping("/templates/{name}")
	public void updateTemplate(@RequestBody Template template,@PathVariable("name") String name) {
		templateService.updateTemplate(name, template);
	}
	@DeleteMapping("/templates/{name}")
	public void deleteTemplate(@PathVariable("name") String name) {
		templateService.deleteTemplate(name);
	}
}
