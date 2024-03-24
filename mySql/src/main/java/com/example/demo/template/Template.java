package com.example.demo.template;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.input.Input;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "templates")
public class Template {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "added_inputs")
    private List<Input> inputs;
    
    Template(String name, List<Input> inputs){
    	this.name = name;
    	this.inputs = inputs;
    }
    Template(){
    	this.name = "";
    	this.inputs = new ArrayList<Input>();
    }
    public void updateValues(Template template) {
    	this.name = template.getName();
    	this.inputs = template.getInputs();
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
