package com.eniso.regimi.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eniso.regimi.models.Partner;
import com.eniso.regimi.repository.PartnerRepository;
import com.eniso.regimi.repository.RoleRepository;

@Service
@ComponentScan(basePackageClasses = PartnerRepository.class)
public class PartnerServiceImpl implements PartnerService {
	@Autowired
	private PartnerRepository partnerRepository;

	@Autowired
	RoleRepository roleRepository;
	
	
	// public InstitutionServiceImpl() {}

	public PartnerServiceImpl( PartnerRepository partnerRepository) {
		super();
		this.partnerRepository = partnerRepository;
	}

	@Override
	public List<Partner> findAll() {
		return partnerRepository.findAll();
	}

	@Override
	public Partner findById(String theId) {
		Optional<Partner> result = partnerRepository.findById(theId);

		Partner theControl = null;

		if (result.isPresent()) {
			theControl = result.get();
		} else {
			// we didn't find the participant
			throw new RuntimeException("Did not find institution id - " + theId);
		}

		return theControl;
	}

	@Override
	public void save(Partner partner) {
		partnerRepository.save(partner);

	}

	@Override
	public void deleteById(String theId) {
		partnerRepository.deleteById(theId);
	}

	@Override
	public Partner findByName(String name) {
		// TODO Auto-generated method stub
		return partnerRepository.findByName(name);
	}

	@Override
	public List<Partner> findByCity(String city) {
		// TODO Auto-generated method stub
		return partnerRepository.findByCity(city);
	}

	@Override
	public ResponseEntity<?> update(Partner partner) {
		// TODO Auto-generated method stub
		return null;
	}

}
