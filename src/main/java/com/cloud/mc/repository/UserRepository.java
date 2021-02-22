package com.cloud.mc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cloud.mc.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findOne(String id);
	
}
