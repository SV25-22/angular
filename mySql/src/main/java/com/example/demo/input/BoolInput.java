package com.example.demo.input;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity

public class BoolInput extends Input{
	private boolean value;
	private boolean defaultValue;
	public BoolInput(boolean value, boolean defaultValue,String shortcut) {
		super();
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public BoolInput() {
		super();
	}
	public BoolInput(String label, String shortcut,boolean value, boolean defaultValue) {
		super(label,shortcut);
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	
	@Override
	public void updateValues(Input input) {
		this.label = input.getLabel();
		this.shortcut = input.getShortcut();
		if(input instanceof BoolInput) {
			BoolInput boolInput = (BoolInput) input;
			this.value = boolInput.isValue();
			this.defaultValue = boolInput.isDefaultValue();
		}
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
