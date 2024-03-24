package com.example.demo.input;

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
public class InputController {
	@Autowired
	private InputService inputService;
	
	@GetMapping("/inputs")
	public List<Input> getAllInputs(){
		return inputService.getAllInputs();
	}
	@GetMapping("/inputs/{label}")
	public List<Input> getInput(@PathVariable("label") String label){
		return inputService.getInput(label);
	}
	@PostMapping("/inputs")
	public void addInput(@RequestBody Input input) {
		inputService.addInput(input);
	}
	@PutMapping("/inputs/{label}")
	public void updateInput(@RequestBody Input input, @PathVariable("label") String label) {
		inputService.updateInput(label,input);
	}
	@DeleteMapping("/inputs/{label}")
	public void deleteInput(@PathVariable("label") String label) {
		inputService.deleteInput(label);
	}
	
}
