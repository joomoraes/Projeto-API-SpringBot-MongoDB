package com.cloud.mc.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.mc.domain.Post;
import com.cloud.mc.domain.User;
import com.cloud.mc.repository.UserRepository;

@Service
public class PostServices {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		User post = repo.findOne(id);
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post;
	}
	
	public List<User> findByTitle(String text) {
		return repo.findAll();
	}
	
	// public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		// maxDate =  new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		
	// }

}
