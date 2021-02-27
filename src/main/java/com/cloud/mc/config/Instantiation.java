package com.cloud.mc.config;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cloud.mc.DTO.AuthorDTO;
import com.cloud.mc.DTO.CommentDTO;
import com.cloud.mc.domain.Post;
import com.cloud.mc.domain.User;
import com.cloud.mc.repository.PostRepository;
import com.cloud.mc.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	// postRepository.deleteAll();
	
	@Override 
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		
		Post post1 =  new Post(null, sdf.parse("21/02/2018"), "Partiu Viajem", "Vou viajar para São paula. Abraços!", new AuthorDTO(maria));
		Post post2 =  new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem bro!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Boa viagem bro!", sdf.parse("21/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Boa viagem bro!", sdf.parse("21/03/2018"), new AuthorDTO(maria));
		
		
		// postRepository.save(Arrays.asList(maria, post2));
		
		// userRepository.save(Arrays.asList(maria, alex, bob));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		maria.getPost().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}
}
