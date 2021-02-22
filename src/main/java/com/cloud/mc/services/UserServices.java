package com.cloud.mc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.mc.domain.User;
import com.cloud.mc.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}