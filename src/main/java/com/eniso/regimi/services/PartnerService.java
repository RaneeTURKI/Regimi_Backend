package com.eniso.regimi.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.eniso.regimi.models.Partner;


public interface PartnerService {
	public List<Partner> findAll();

	public Partner findById(String theId);

	public Partner findByName(String name) ;


	//public Partner findByPhoneNumber(String email) ;

	public void save(Partner partner);

	public void deleteById(String theId);

	//public List<PartnerReprentative> getRepresentative( long entrepriseId) ;

	public  ResponseEntity<?>   update (@RequestBody Partner partner);

	List<Partner> findByCity(String city);

}
