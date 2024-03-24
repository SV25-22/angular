package com.example.demo.template;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.input.Input;
import com.example.demo.input.IntInput;
import com.example.demo.input.StringInput;

@Service
public class TemplateService {
	@Autowired
	private TemplateRepository templateRepository;
	public List<Template> getAllTemplates(){
		List<Template> templates = new ArrayList<>();
		templateRepository.findAll().forEach(templates::add);
		return templates;
	}
	public List<Template> getTemplate(String name) {
		if(name == null) {
			return null;
		}
		if(!templateRepository.existsByName(name)) {
			return null;
		}
		return templateRepository.findByName(name);
	}
	public void addTemplate(Template template) {
		templateRepository.save(template);
	}
	public void updateTemplate(String name, Template template) {
		if(templateRepository.existsByName(name)) {
			Template foundTemplate = templateRepository.findByName(name).get(0);
			foundTemplate.updateValues(template);
			templateRepository.save(foundTemplate);
		}else {
			return;
		}
	}
	public void deleteTemplate(String name) {
		templateRepository.deleteByName(name);
	}
}
