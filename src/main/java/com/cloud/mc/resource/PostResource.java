package com.cloud.mc.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.mc.domain.Post;
import com.cloud.mc.domain.User;
import com.cloud.mc.resource.util.URL;
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
	


	@RequestMapping(value = "/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<User> findById1(@RequestParam(value = "text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/fullsearch", method=RequestMethod.GET)
	public ResponseEntity<User> fullSearch(
			@RequestParam(value = "text", defaultValue="") String text,
			@RequestParam(value = "minDate", defaultValue="") String maxDate,
			@RequestParam(value = "maxDate", defaultValue="") String minDate) {
		text = URL.decodeParam(text);
		Date Datemin = URL.convertDate(minDate, new Date(0L));
		Date Datemax = URL.convertDate(maxDate, new Date(0L));
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
