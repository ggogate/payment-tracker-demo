package com.syntel.apps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.apps.services.UserService;
import com.syntel.apps.models.User;

@RestController
public class UserController {
	
	@Autowired
	UserService userSvc;
	

	@GetMapping("/users/list")
	public List<User> list(){
		return (List<User>)userSvc.getAllUsers();
	}
}
