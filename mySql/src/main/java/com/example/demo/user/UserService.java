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
	public User getUser(String username) {
		if(username == null) {
			return null;
		}
		if(!userRepository.existsByUsername(username)){
			return null;
		}
	
		return userRepository.findByUsername(username);
	}
	public void updateUser(String username, User user) {
		if(userRepository.existsByUsername(username)) {
			User foundUser = userRepository.findByUsername(username);
			foundUser.updateValues(user);
			userRepository.save(foundUser);
		}else {
			return;
		}
	}
	public void deleteUser(String username) {
		userRepository.deleteByUsername(username);
	}
	public User loginUser(LoginData data) {
		if(data == null || data.getUsername() == null) {
			return null;
		}
		if(!userRepository.existsByUsername(data.getUsername())) {
			return null;
		}
		User user = userRepository.findByUsername(data.getUsername());
		if(user == null) {
			return null;
		}
		if(user.checkPassword(data.getPassword())) {
			return user;
		}
		return null;
	}
}
