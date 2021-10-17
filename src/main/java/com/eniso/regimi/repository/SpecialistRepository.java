package com.eniso.regimi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eniso.regimi.models.Specialist;
import com.eniso.regimi.models.Subscriber;
@Repository
public interface SpecialistRepository extends MongoRepository<Specialist, String> {

	Optional<Specialist> findById(String Id) ; 
	List<Specialist> findByEmail(String email);
	List<Specialist> findByGender(String gender);
	List<Specialist> findBySpeciality(String speciality);
	List<Specialist> findByFirstName(String firstName);
	List<Specialist> findByLastName(String lastName);
	List<Specialist> findByRegion(String Region);
	

    Boolean existsByEmail(String email);
    Boolean existsByFirstName(String firstName);


   

}
