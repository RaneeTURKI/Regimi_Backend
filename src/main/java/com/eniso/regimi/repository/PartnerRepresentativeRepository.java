package com.eniso.regimi.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eniso.regimi.models.Partner;
import com.eniso.regimi.models.PartnerRepresentative;



@Repository
public interface PartnerRepresentativeRepository extends MongoRepository<PartnerRepresentative, String> {
	Optional<PartnerRepresentative> findByEmail(String email);
	Optional<PartnerRepresentative> findByFirstNameRep(String firstName);
	Optional<PartnerRepresentative> findByPartner(Partner partner);
	

    Boolean existsByEmail(String email);



   

}
