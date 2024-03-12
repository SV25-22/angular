package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	public void addUser(User user) {
		userRepository.save(user);
	}
	public User getUser(String id) {
		if(id == null) {
			return null;
		}
		if(!userRepository.existsById(id)){
			return null;
		}
	
		return userRepository.findById(id).orElse(null);
	}
	public void updateUser(String id, User user) {
		userRepository.save(user);
	}
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
	public User loginUser(LoginData data) {
		if(data == null || data.getUsername() == null) {
			return null;
		}
		if(!userRepository.existsById(data.getUsername())) {
			return null;
		}
		User user = userRepository.findById(data.getUsername()).orElse(null);
		if(user == null) {
			return null;
		}
		if(user.checkPassword(data.getPassword())) {
			return user;
		}
		return null;
	}
}
