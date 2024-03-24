package com.example.demo.user;


import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String username;
	private String name;
	private String surname;
	private String password;
	private boolean isAdmin;
	
	public User() {
		username = "";
		name = "";
		surname = "";
		password = "";
		isAdmin = false;
	}
	public User(String username,String name,String surname, String password, boolean isAdmin) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
		this.isAdmin = isAdmin;
	}
	
	public void updateValues(User user) {
		this.username = user.getUsername();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.password = user.getPassword();
		this.isAdmin = user.isAdmin();
	}
	public boolean checkPassword(String password) {
		return BCrypt.checkpw(password, this.password);
	}
	public void hashPassword() {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
