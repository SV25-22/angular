package com.example.demo.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity

public class IntInput extends Input{
	private int value;
	private int defaultValue;
	public IntInput(int value, int defaultValue, String shortcut) {
		super();
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public IntInput() {
		super();
	}
	public IntInput(String id, String shortcut, int value, int defaultValue) {
		super(id,shortcut);
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	
	@Override
	public void updateValues(Input input) {
		this.label = input.getLabel();
		this.shortcut = input.getShortcut();
		if(input instanceof IntInput) {
			IntInput intInput = (IntInput) input;
			this.value = intInput.getValue();
			this.defaultValue = intInput.getDefaultValue();
		}
	}
    @JsonProperty("value")
	public int getValue() {
		return value;
	}
    @JsonProperty("value")
	public void setValue(int value) {
		this.value = value;
	}
    @JsonProperty("defaultValue")
	public int getDefaultValue() {
		return defaultValue;
	}
    @JsonProperty("defaultValue")
	public void setDefaultValue(int defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}
