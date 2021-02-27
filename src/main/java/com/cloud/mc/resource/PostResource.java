package com.cloud.mc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.mc.domain.User;
import com.cloud.mc.services.PostServices;

@RestController
@RequestMapping(value = "/users")
public class PostResource {

	@Autowired
	private PostServices service;
	@SuppressWarnings("unused")
	private String id;
	

	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
