package com.example.demo.input;

import jakarta.persistence.Entity;

public class StringInput extends Input{
	private String value;
	private String defaultValue;
	public StringInput(String value, String defaultValue, String shortcut) {
		super();
		this.type = "string";
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public StringInput() {
		super();
		this.type = "string";
	}
	public StringInput(String label, String value, String defaultValue, String shortcut) {
		super(label,shortcut);
		this.type = "string";
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
