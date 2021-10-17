package com.eniso.regimi.payload.request;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequestSubscriber {
	  
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 20)
    private String region;

    @NotBlank
    @Size(min = 3, max = 20)
    private String phoneNumber;

    @NotBlank
    @Size(min = 8, max = 40)
    private String password;
    
    private Set<String> roles;
    
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

    public Set<String> getRoles() {
        return this.roles;
      }
      
      public void setRole(Set<String> roles) {
        this.roles = roles;
      }

    public String getRegion() {
        return region;
    }

    public void setAddress(String region) {
        this.region = region;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

	public void setRegion(String region) {
		this.region = region;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
    
    

}
