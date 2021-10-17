package com.eniso.regimi.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.eniso.regimi.models.Role;


public class SignUpRequest {
	
	    
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
	    
	    
	    
	    

}
