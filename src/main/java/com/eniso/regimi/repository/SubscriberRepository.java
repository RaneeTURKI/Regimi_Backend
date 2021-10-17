package com.eniso.regimi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eniso.regimi.models.Subscriber;


@Repository
public interface SubscriberRepository extends MongoRepository<Subscriber, String> {
	Optional<Subscriber> findById(String Id) ; 
	List<Subscriber> findByEmail(String email);
	List<Subscriber> findByGender(String gender);
	List<Subscriber> findByBirthday(Date birthday);
	List<Subscriber> findByFirstName(String firstName);
	List<Subscriber> findByLastName(String lastName);
	List<Subscriber> findByRegion(String Region);
	

    Boolean existsByEmail(String email);
    Boolean existsByFirstName(String firstName);


   

}
