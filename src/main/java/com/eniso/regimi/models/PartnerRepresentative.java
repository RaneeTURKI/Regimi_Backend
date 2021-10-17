package com.eniso.regimi.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@TypeAlias("partnerRepresentative")
public class PartnerRepresentative extends User {
	 @NotBlank
	  @Size(max = 20)
	  private String firstNameRep;
	  
	  @NotBlank
	  @Size(max = 20)
	  private String lastNameRep;
	  
	  @DBRef
	  private Partner partner;

	public PartnerRepresentative(@NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @NotBlank @Size(max = 16) String phoneNumber,
			@Size(max = 16) String region, Set<Role> roles, @NotBlank @Size(max = 20) String firstNameRep, @NotBlank @Size(max = 20) String lastNameRep,
			@NotBlank @Size(max = 50) String name, @NotBlank @Size(max = 50) String category,
			@NotBlank @Size(max = 50) String street, @NotBlank @Size(max = 15) String city,
			@NotBlank @Size(max = 5) String postalCode) {
		super(email, password, phoneNumber, region, roles);
		//Partner partner=new Partner(name,category,street,city,postalCode);
		this.firstNameRep = firstNameRep;
		this.lastNameRep = lastNameRep;
		//this.partner = partner;
	}



	  
	  

}
