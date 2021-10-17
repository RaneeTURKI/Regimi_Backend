package com.eniso.regimi.models;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.eniso.regimi.services.SequenceGeneratorService;

@Document(collection = "subscribers")
//@TypeAlias("subscriber")
public class Subscriber extends User{
	  

	
	@NotBlank
	  @Size(max = 20)
	  private String firstName;

	@NotBlank
	  @Size(max = 20)
	  private String lastName;
	  
	  @NotBlank
	  @Size(max = 20)
	  private String gender;
	  
	  
	  private int height ;
	  
	  private int weight ;
	  
	  private LocalDate birthday;

	  
	  
	public Subscriber(@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password,
			@NotBlank @Size(max = 16) String phoneNumber, @Size(max = 16) String region, Set<Role> roles,
			@NotBlank @Size(max = 20) String firstName, @NotBlank @Size(max = 20) String lastName,
			@NotBlank @Size(max = 20) String gender,  int height,  int weight,
			 LocalDate birthday) {
        super.setEmail(email);
        super.setPassword(password);
        super.setPhoneNumber(phoneNumber);
        super.setRegion(region);
        super.setRoles(roles);
        
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
	}
	
	//for sign up
	public Subscriber(@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password,
			@NotBlank @Size(max = 16) String phoneNumber, @Size(max = 16) String region, 
			@NotBlank @Size(max = 20) String firstName, @NotBlank @Size(max = 20) String lastName,
			@NotBlank @Size(max = 20) String gender,  int height,  int weight,
			 LocalDate birthday) {

        super.setEmail(email);
        super.setPassword(password);
        super.setPhoneNumber(phoneNumber);
        super.setRegion(region);
        //super.setRoles(roles);
        
        
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
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


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	@Override
    public String toString() {
        return "Subscriber{" + "id=" + super.getId() + ", email='" + super.getEmail() + '\'' +
                ", name='" + firstName + '\'' + ", gender='" + gender + '\'' + '}';
    }



	

	  
	  

}
