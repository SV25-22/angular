package com.example.demo.input;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputService {
	@Autowired
	private InputRepository inputRepository;
	public List<Input> getAllInputs(){
		List<Input> inputs = new ArrayList<>();
		inputRepository.findAll().forEach(inputs::add);
		return inputs;
	}
	
	public List<Input> getInput(String label){
		if(label == null) {
			return null;
		}
		if(!inputRepository.existsByLabel(label)) {
			return null;
		}
		return inputRepository.findByLabel(label);
	}
	
	public void addInput(Input input) {
		inputRepository.save(input);
	}
	public void updateInput(String label, Input input) {
		if(inputRepository.existsByLabel(label)) {
			Input foundInput = inputRepository.findByLabel(label).get(0);
			foundInput.updateValues(input);
			inputRepository.save(foundInput);
		}else {
			return;
		}
	}
	public void deleteInput(String label) {
		inputRepository.deleteByLabel(label);
	}
}
