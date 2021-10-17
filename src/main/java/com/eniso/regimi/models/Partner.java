package com.eniso.regimi.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "partners")
public class Partner {
	@Id
	  private String id;  
	

	@NotBlank
	  @Size(max = 50)
	  private String name;
	  
	  @NotBlank
	  @Size(max = 50)
	  private String category;
	  
	  @NotBlank
	  @Size(max = 50)
	  private String street;
	  @NotBlank
	  @Size(max = 15)
	  private String city;
	  @NotBlank
	  @Size(max = 5)
	  private String postalCode;
	  
	  public Partner(@NotBlank @Size(max = 50) String name, @NotBlank @Size(max = 50) String category,
			@NotBlank @Size(max = 50) String street, @NotBlank @Size(max = 15) String city,
			@NotBlank @Size(max = 5) String postalCode) {
		
		this.name = name;
		this.category = category;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}  
	 
	  
	  
	  
	  

}
