package com.eniso.regimi.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

import com.eniso.regimi.models.User;


public interface UserRepository extends MongoRepository<User, String> {
	  
	  Optional<User> findById(String id);	
	  Optional<User> findByEmail(String email);
	  List<User> findByRegion(String region);

	  Boolean existsByEmail(String email);

	  Boolean existsByPhoneNumber(String phone);
	}
