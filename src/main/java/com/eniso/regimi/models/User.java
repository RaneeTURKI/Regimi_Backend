package com.eniso.regimi.models;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.eniso.regimi.services.SequenceGeneratorService;

@Document(collection = "users")
public class User {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";

	
// *****all users***** 	
  @Id
  private String id;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @NotBlank
  @Size(max = 16)
  private String phoneNumber;
  
  
  @Size(max = 16)
  private String region;

  @DBRef
  private Set<Role> roles = new HashSet<>();
  
  private SequenceGeneratorService sequenceGeneratorService;
  
//  //****Not Common fields *****//
//  @Size(max = 20)
//  private String firstName;
//  
//  @Size(max = 20)
//  private String lastName;
//  
//  @Size(max = 100)
//  private String address;
//  
//  //***Subscriber**//
//  private int height ;
//  private float weight ;
//  private LocalDate birthday;
//  
//  @Size(max = 20)
//  private String gender;
//  
//  //***Partner***//
//  @Size(max = 20)
//  private String partnerName;
//  @Size(max=20)
//  private String category;
  	
  public User() {
  }
  
  
  public User(@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password,
			@NotBlank @Size(max = 16) String phoneNumber, @Size(max = 16) String region) {
		// super();
	  //this.id=String.valueOf(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		//System.out.println("this.id");
		//System.out.println(String.valueOf(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME)));
		

		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.region = region;
	}
	public User(@NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password,
			@NotBlank @Size(max = 16) String phoneNumber, @Size(max = 16) String region, Set<Role> roles) {
		// super();
		
		//System.out.println(this.id);
		
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.region = region;
		this.roles = roles;
	}
	
	public User( @NotBlank @Size(max = 120) String id, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 120) String password,
			@NotBlank @Size(max = 16) String phoneNumber, @Size(max = 16) String region, Set<Role> roles) {
		// super();
		
		//System.out.println(this.id);
		this.id=id;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.region = region;
		this.roles = roles;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	@Override
    public String toString() {
        return "User{" + "id=" + id + ", email='" + email + '\'' +
                ", region='" + region + '\'' + ", roles='" + roles + '\'' + '}';
    }

}




/*
Un administrateur
Un spécialiste (nutritionniste, diététicien, diabétologue, coach sportif)
Un partenaire commercial : toute entité externe voulant bénéficier d’un espace publicitaire (parapharmacie, restaurant, point de vente bio, etc.).
Un abonné : toute personne inscrite et voulant bénéficier des services de l’application.

 */ 


