package com.example.demo.input;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;


@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type"
)
@JsonSubTypes({
	@JsonSubTypes.Type(value = BoolInput.class, name = "bool"),
	@JsonSubTypes.Type(value = FloatInput.class, name = "float"),
	@JsonSubTypes.Type(value = IntInput.class, name = "int"),
	@JsonSubTypes.Type(value = StringInput.class, name = "string")
})


@Entity
@Table(name = "input")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "input_type", discriminatorType = DiscriminatorType.STRING)
public class Input {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String label;
	protected String shortcut;
	
	public Input() {
		this.label = "";
		this.shortcut = "";
	}
	public Input(String label) {
		this.label = label;
	}
	public Input(String label, String shortcut) {
		this.label = label;
		this.shortcut = shortcut;
	}
	public Input(Input i) {
		this.label = i.getLabel();
		this.shortcut = i.getShortcut();
	}
	
	public void updateValues(Input input) {
		this.label = input.getLabel();
		this.shortcut = input.getShortcut();
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getShortcut() {
		return shortcut;
	}
	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}
}
