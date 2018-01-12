package com.syntel.apps.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.apps.dao.UserRepository;
import com.syntel.apps.models.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<User>();
		Iterator<User> iterator = userRepo.findAll().iterator();
		while(iterator.hasNext()){
			users.add(iterator.next());
		}
		return users;
	}
	
}
