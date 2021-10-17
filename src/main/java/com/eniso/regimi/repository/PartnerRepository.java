package com.eniso.regimi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eniso.regimi.models.Partner;

@Repository
public interface PartnerRepository extends MongoRepository<Partner, String> {
	//Optional<Partner> findByEmail(String email);
	Partner findByName(String name);
	List<Partner> findByCity(String city);
	List<Partner> findByCategory(String category);
	

    //Boolean existsByEmail(String email);
    Boolean existsByName(String name);


   

}

