package com.example.demo.template;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.input.Input;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Template {
	@Id
	private String name;
    @ElementCollection
    @CollectionTable(name = "template_input", joinColumns = @JoinColumn(name = "template_name"))
    @Column(name = "input_value")
    private List<Input> inputs;
    Template(String name, List<Input> inputs){
    	this.name = name;
    	this.inputs = inputs;
    }
    Template(){
    	this.name = "";
    	this.inputs = new ArrayList<Input>();
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Input> getInputs() {
		return inputs;
	}
	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}
    
}
