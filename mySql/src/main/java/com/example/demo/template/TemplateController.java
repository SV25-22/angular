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
	@GetMapping("/templates/{id}")
	public Template getTemplate(@PathVariable("id") String id) {
		return templateService.getTemplate(id);
	}
	@PostMapping("/templates")
	public void addTemplate(@RequestBody Template template) {
		templateService.addTemplate(template);
	}
	@PutMapping("/templates/{id}")
	public void updateTemplate(@RequestBody Template tempalte,@PathVariable("id") String id) {
		templateService.updateTemplate(id, tempalte);
	}
	@DeleteMapping("/templates/{id}")
	public void deleteTemplate(@PathVariable("id") String id) {
		templateService.deleteTemplate(id);
	}
}
