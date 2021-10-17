package com.eniso.regimi.models;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "specialists")
public class Specialist  extends User {
	
	@NotBlank
	@Size(max = 20)
	private String firstName;

	@NotBlank
	@Size(max = 20)
	private String lastName;

	@NotBlank
	@Size(max = 20)
	private String gender;

	@NotBlank
	@Size(max = 20)
	private String speciality;
	  
	  
	  public Specialist (@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password,
				@NotBlank @Size(max = 16) String phoneNumber, @Size(max = 16) String region, Set<Role> roles,
				@NotBlank @Size(max = 20) String firstName, @NotBlank @Size(max = 20) String lastName,
				@NotBlank @Size(max = 20) String gender, @NotBlank @Size(max = 20) String speciality) {
	        super.setEmail(email);
	        super.setPassword(password);
	        super.setPhoneNumber(phoneNumber);
	        super.setRegion(region);
	        super.setRoles(roles);
	        
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.speciality = speciality;
		}
	  
	  //constructor for sign up of a specialist
	  public Specialist (@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password,
				@NotBlank @Size(max = 16) String phoneNumber, @Size(max = 16) String region, 
				@NotBlank @Size(max = 20) String firstName, @NotBlank @Size(max = 20) String lastName,
				@NotBlank @Size(max = 20) String gender, @NotBlank @Size(max = 20) String speciality) {
	        super.setEmail(email);
	        super.setPassword(password);
	        super.setPhoneNumber(phoneNumber);
	        super.setRegion(region);
	        //super.setRoles(roles);
	        
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.speciality = speciality;
		}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	  
	  


}
