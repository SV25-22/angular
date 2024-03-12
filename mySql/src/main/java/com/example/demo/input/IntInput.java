package com.example.demo.input;

import jakarta.persistence.Entity;

public class IntInput extends Input{
	private int value;
	private int defaultValue;
	public IntInput(int value, int defaultValue, String shortcut) {
		super();
		this.type = "int";
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public IntInput() {
		super();
		this.type = "int";
	}
	public IntInput(String id, String shortcut, int value, int defaultValue) {
		super(id,shortcut);
		this.type = "int";
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(int defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}
