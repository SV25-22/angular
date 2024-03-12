package com.example.demo.input;

import jakarta.persistence.Entity;


public class FloatInput extends Input{
	private float value;
	private float defaultValue;
	
	public FloatInput(float value,float defaultValue,String shortcut) {
		super();
		this.type = "float";
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public FloatInput() {
		super();
		this.type = "float";
	}
	public FloatInput(String label, String shortcut,float value, float defaultValue) {
		super(label,shortcut);
		this.type = "float";
		this.shortcut=  shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public float getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(float defaultValue) {
		this.defaultValue = defaultValue;
	}
}
