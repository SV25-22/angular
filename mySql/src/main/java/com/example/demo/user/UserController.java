package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") String username) {
		return userService.getUser(username);
	}
	
	@PostMapping("/users/login")
	public User login(@RequestBody LoginData data) {
		return userService.loginUser(data);
	}
	
	//login alternative
	@GetMapping("/users/{username}/{password}")
	public User loginUrl(@PathVariable("username") String username, @PathVariable("password") String password) {
		return userService.loginUser(new LoginData(username,password));
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		user.hashPassword();
		userService.addUser(user);
	}
	@PutMapping("/users/{id}")
	public void updateUser(@RequestBody User user,@PathVariable("id") String username) {
		user.hashPassword();
		userService.updateUser(username, user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(id);
	}
}
