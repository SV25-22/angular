package com.example.demo.picture;
import java.util.List;

import com.example.demo.input.Input;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
@Embeddable
public class Picture {
    //@ElementCollection
	//private List<Input> inputs;
	private boolean done;
	private String relPath;
	/*
	public List<Input> getInputs() {
		return inputs;
	}
	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}
	 */

	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public String getRelPath() {
		return relPath;
	}
	public void setRelPath(String relPath) {
		this.relPath = relPath;
	}
}
