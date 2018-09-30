package com.quark.atom.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quark.atom.mongodb.domain.User;
import com.quark.atom.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@GetMapping
	public List<User> list() {
		return userService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody User user) {
		
	}
	
	@GetMapping("/{id}")
	public User get(@PathVariable("id") String id ) {
		return new User();
	}
	
	@GetMapping("/authLevel/{level}")
	public List<User> getByAuthLevel(@PathVariable("level") String authLevel ) {
		return userService.findUsersWithAuthLevel(authLevel);
	}
}
