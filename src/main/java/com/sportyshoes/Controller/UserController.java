package com.sportyshoes.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sportyshoes.Model.Role;
import com.sportyshoes.Model.User;
import com.sportyshoes.Repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/all")
	List<User> getAllUser(){
		List<User>allUsers = userRepository.findByRole(Role.USER);
		return allUsers;
	}
	
	
	
	/*
	 * Search User
	 */
	
	@GetMapping("/search/{username}")
	User searchUserByUsername(@PathVariable String username) throws Exception {
		
		User user = userRepository.findByUsernameAndRole(username , Role.USER);
		if(user == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username not found");
		return user;
	}

}
