package com.cloud.mc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cloud.mc.domain.Post;
import com.cloud.mc.domain.User;

@Repository
public interface PostRepository extends MongoRepository<User, String>{

	@Query(" <title>: { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContaingIgnoreCase(String text);
	
	@Query("{ $and:[ {date: {$gte: ?1} }, {field: {$lte: ?2} }, { $or: [ { <title>: { $regex: ?0, $options: 'i' } } }, {<body>: { $regex: ?0, $options: 'i' } }}, {'comments.text': { $regex: ?0, $options: 'i' } }} ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
