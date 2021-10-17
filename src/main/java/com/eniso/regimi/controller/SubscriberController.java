package com.eniso.regimi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eniso.regimi.models.Subscriber;
import com.eniso.regimi.models.User;
import com.eniso.regimi.repository.RoleRepository;
import com.eniso.regimi.repository.SubscriberRepository;
import com.eniso.regimi.repository.UserRepository;
import com.eniso.regimi.services.SequenceGeneratorService;
import com.eniso.regimi.services.SubscriberService;




@CrossOrigin(origins = "*")
@RestController
@ComponentScan(basePackageClasses = SubscriberService.class)
@RequestMapping(value = "/api")
public class SubscriberController {
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	SubscriberRepository subscriberRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	SubscriberService subscriberService ; 
	
	@Autowired
	 private SequenceGeneratorService sequenceGeneratorService;
	
	public SubscriberController(SubscriberService theSubscriberService) {
		subscriberService = theSubscriberService;
	}
	// public ControlController () {}

	@GetMapping("/subscribers")
	public List<Subscriber> getAllSubscribers() {
		
		return subscriberService.findAll();
	}
	
	@GetMapping("/subscriber/{subscriberId}")
    public Subscriber getSubscriber(@PathVariable String subscriberId) {

		Subscriber theSubscriber = subscriberService.findById(subscriberId);

        if (theSubscriber == null) {
            throw new RuntimeException("Trainer id not found - " + subscriberId);
        }

        return theSubscriber;
    }
	
	@GetMapping("/subscribers/{region}")
    public List<Subscriber> getSubscribersByRegion(@PathVariable String region) {
		System.out.print("service finding region");
		System.out.print(subscriberRepository.findByRegion(region));
		List<Subscriber> result =  subscriberService.findByRegion(region);
		if (result == null) {
            throw new RuntimeException("Trainer id not found - " + result);
        }

        return result;
        
    }
	
	@PostMapping("/subscribers")
    public Subscriber addSubscriber(@RequestBody Subscriber subscriber) {
		String generatedId= String.valueOf(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		subscriber.setId(generatedId);
		System.out.println("the subscriber id ");
		System.out.println(subscriber.getId()); 
		System.out.println(subscriber.toString());
		User user=new User(subscriber.getId(),subscriber.getEmail(),encoder.encode(subscriber.getPassword()),subscriber.getPhoneNumber(),
				            subscriber.getRegion(),subscriber.getRoles());
		System.out.println("user created here ");

		userRepository.save(user);
		
		System.out.println("user created here ");
		System.out.println(user.toString());
		

        subscriberService.save(subscriber);
        return subscriber;
    }
	
	 @PutMapping("/subscribers")
	    public Subscriber updateSubscriber(@RequestBody Subscriber subscriber) {

		 Subscriber newSubscriber = subscriberService.updateSubscriber(subscriber);
	        return newSubscriber;
	    }

	    @DeleteMapping("/subscribers/{subscriberId}")
	    public String deleteSubscriber(@PathVariable String subscriberId) {

	    	Subscriber tempSubscriber = subscriberService.findById(subscriberId);

	        // throw exception if null

	        if (tempSubscriber == null) {
	            throw new RuntimeException("the trainer id is not found - " + subscriberId);
	        }

	        subscriberService.deleteById(subscriberId);

	        return "Deleted trainer id - " + subscriberId;
	    }

}


