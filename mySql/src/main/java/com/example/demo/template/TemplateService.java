package com.example.demo.template;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateService {
	@Autowired
	private TemplateRepository templateRepository;
	public List<Template> getAllTemplates(){
		List<Template> templates = new ArrayList<>();
		templateRepository.findAll().forEach(templates::add);
		return templates;
	}
	public Template getTemplate(String id) {
		if(id == null) {
			return null;
		}
		if(!templateRepository.existsById(id)) {
			return null;
		}
		return templateRepository.findById(id).orElse(null);
	}
	public void addTemplate(Template template) {
		templateRepository.save(template);
	}
	public void updateTemplate(String id, Template template) {
		templateRepository.save(template);
	}
	public void deleteTemplate(String id) {
		templateRepository.deleteById(id);
	}
}
