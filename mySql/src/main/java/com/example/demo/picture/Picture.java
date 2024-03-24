package com.example.demo.picture;
import java.util.List;

import com.example.demo.input.Input;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "pictures")
public class Picture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "picture_inputs")
	private List<Input> inputs;
	private boolean done;
	private String relPath;
	public void updateValues(Picture picture) {
		this.inputs = picture.getInputs();
		this.done = picture.isDone();
		this.relPath = picture.getRelPath();
	}

	public List<Input> getInputs(){
		return inputs;
	}
	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}
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
