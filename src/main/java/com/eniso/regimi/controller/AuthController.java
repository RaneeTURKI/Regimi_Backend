package com.eniso.regimi.controller;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eniso.regimi.models.ERole;
import com.eniso.regimi.models.Role;
import com.eniso.regimi.models.Specialist;
import com.eniso.regimi.models.Subscriber;
import com.eniso.regimi.models.User;
import com.eniso.regimi.payload.request.LoginRequest;
import com.eniso.regimi.payload.request.SignUpRequest;
import com.eniso.regimi.payload.request.SignUpRequestSpecialist;
import com.eniso.regimi.payload.request.SignUpRequestSubscriber;
import com.eniso.regimi.payload.response.JwtResponse;
import com.eniso.regimi.payload.response.MessageResponse;
import com.eniso.regimi.repository.RoleRepository;
import com.eniso.regimi.repository.UserRepository;
import com.eniso.regimi.repository.SpecialistRepository;


import com.eniso.regimi.repository.SubscriberRepository;
import com.eniso.regimi.security.jwt.JwtUtils;
import com.eniso.regimi.services.SequenceGeneratorService;
import com.eniso.regimi.services.UserDetailsImpl;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	SubscriberRepository subscriberRepository;
	
	@Autowired
	SpecialistRepository specialistRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	 private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	JwtUtils jwtUtils;
	
	@GetMapping("/users/{region}")
    public List<User> getSubscribersByRegion(@PathVariable String region) {
		

        return userRepository.findByRegion(region);
    }

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		System.out.print("jwtt created" );
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		System.out.print("Logged in as" );
		System.out.print(roles);

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()), signUpRequest.getPhoneNumber(), signUpRequest.getRegion());
		
		//generate sequence
		
				String generatedId= String.valueOf(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
				user.setId(generatedId);
				System.out.println("this.id");
				System.out.println(generatedId);

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role subscriberRole = roleRepository.findByName(ERole.ROLE_SUBSCRIBER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(subscriberRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "specialist":
					Role specialistRole = roleRepository.findByName(ERole.ROLE_SPECIALIST)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(specialistRole);

					break;
				case "partner":
					Role partnerRole = roleRepository.findByName(ERole.ROLE_PARTNER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(partnerRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@PostMapping("/signupSubscriber")
	public ResponseEntity<?> registerSubscriber(@Valid @RequestBody SignUpRequestSubscriber signUpRequest) {
		System.out.println("entrer in register subscriber");
		
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already taken!"));
		}

		// Create new subscriber's account
		User user = new User(signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()), signUpRequest.getPhoneNumber(), signUpRequest.getRegion());
		
		Subscriber subscriber = new Subscriber(signUpRequest.getEmail(),
				 encoder.encode(signUpRequest.getPassword()), signUpRequest.getPhoneNumber(), signUpRequest.getRegion(),
				 signUpRequest.getFirstName(),signUpRequest.getLastName(),signUpRequest.getGender(),signUpRequest.getHeight(),
				 signUpRequest.getWeight(),signUpRequest.getBirthday());
		
				 
		
				//generate sequence
		
				String generatedId= String.valueOf(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
				user.setId(generatedId);
				System.out.println("this.id");
				System.out.println(generatedId);

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role subscriberRole = roleRepository.findByName(ERole.ROLE_SUBSCRIBER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(subscriberRole);
		}

		user.setRoles(roles);
		subscriber.setRoles(roles);
		userRepository.save(user);
		subscriberRepository.save(subscriber);

		return ResponseEntity.ok(new MessageResponse("Subscriber registered successfully!"));
	}
	
	@PostMapping("/signupSpecialist")
	public ResponseEntity<?> registerSpecialist(@Valid @RequestBody SignUpRequestSpecialist signUpRequest) {
		System.out.println("entrer in register Specialist");
		
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already taken!"));
		}

		// Create new Specialist's account
		User user = new User(signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()), signUpRequest.getPhoneNumber(), signUpRequest.getRegion());
		
		Specialist specialist = new Specialist(signUpRequest.getEmail(),
				 encoder.encode(signUpRequest.getPassword()), signUpRequest.getPhoneNumber(), signUpRequest.getRegion(),
				 signUpRequest.getFirstName(),signUpRequest.getLastName(),signUpRequest.getGender(),signUpRequest.getSpeciality());
			
				//generate sequence
		
				String generatedId= String.valueOf(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
				user.setId(generatedId);
				System.out.println("this.id");
				System.out.println(generatedId);

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role subscriberRole = roleRepository.findByName(ERole.ROLE_SPECIALIST)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(subscriberRole);
		}

		user.setRoles(roles);
		specialist.setRoles(roles);
		userRepository.save(user);
		specialistRepository.save(specialist);

		return ResponseEntity.ok(new MessageResponse("Subscriber registered successfully!"));
	}
}

