package com.example.demo.input;

import jakarta.persistence.Entity;

public class BoolInput extends Input{
	private boolean value;
	private boolean defaultValue;
	public BoolInput(boolean value, boolean defaultValue,String shortcut) {
		super();
		this.type = "bool";
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public BoolInput() {
		super();
		this.type = "bool";
	}
	public BoolInput(String label, String shortcut,boolean value, boolean defaultValue) {
		super(label,shortcut);
		this.type = "bool";
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	public boolean isDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(boolean defaultValue) {
		this.defaultValue = defaultValue;
	}
}
