package com.example.demo.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity

public class StringInput extends Input{
	private String value;
	private String defaultValue;
	public StringInput(String value, String defaultValue, String shortcut) {
		super();
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	public StringInput() {
		super();
	}
	public StringInput(String label, String value, String defaultValue, String shortcut) {
		super(label,shortcut);
		this.shortcut = shortcut;
		this.value = value;
		this.defaultValue = defaultValue;
	}
	
	@Override
	public void updateValues(Input input) {
		this.label = input.getLabel();
		this.shortcut = input.getShortcut();
		if(input instanceof StringInput) {
			StringInput stringInput = (StringInput) input;
			this.value = stringInput.getValue();
			this.defaultValue = stringInput.getDefaultValue();
		}
	}
	
    @JsonProperty("value")
	public String getValue() {
		return value;
	}
    @JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}
    @JsonProperty("defaultValue")
	public String getDefaultValue() {
		return defaultValue;
	}
    @JsonProperty("defaultValue")
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
