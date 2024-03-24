package com.example.demo.input;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity

public class FloatInput extends Input{
	private float value;
	private float defaultValue;
	
	public FloatInput(float value,float defaultValue,String shortcut) {
		super();
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public FloatInput() {
		super();
	}
	public FloatInput(String label, String shortcut,float value, float defaultValue) {
		super(label,shortcut);
		this.shortcut=  shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	@Override
	public void updateValues(Input input) {
		this.label = input.getLabel();
		this.shortcut = input.getShortcut();
		if(input instanceof FloatInput) {
			FloatInput floatInput = (FloatInput) input;
			this.value = floatInput.getValue();
			this.defaultValue = floatInput.getDefaultValue();
		}
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
