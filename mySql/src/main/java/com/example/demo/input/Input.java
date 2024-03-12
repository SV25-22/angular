package com.example.demo.input;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
@Embeddable
public class Input {
	protected String label;
	protected String type;
	protected String shortcut;
	
	public Input() {
		this.label = "";
		this.type = "";
		this.shortcut = "";
	}
	public Input(String label) {
		this.label = label;
	}
	public Input(String label, String shortcut) {
		this.label = label;
		this.shortcut = shortcut;
		this.type = "";
	}
	public Input(Input i) {
		this.label = i.getLabel();
		this.type = i.getType();
		this.shortcut = i.getShortcut();
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getShortcut() {
		return shortcut;
	}
	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}
}
