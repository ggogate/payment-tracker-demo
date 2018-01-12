package com.syntel.apps.dao;

import org.springframework.data.repository.CrudRepository;

import com.syntel.apps.models.User;

public interface UserRepository extends CrudRepository<User, String>{
	
}
