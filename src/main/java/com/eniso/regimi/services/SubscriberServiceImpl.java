package com.eniso.regimi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.eniso.regimi.models.Subscriber;
import com.eniso.regimi.repository.SubscriberRepository;


@Service
@ComponentScan(basePackageClasses = SubscriberRepository.class)
public class SubscriberServiceImpl implements SubscriberService {
	
	@Autowired
	private SubscriberRepository subscriberRepository;

	public SubscriberServiceImpl() {
	}

	public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
		this.subscriberRepository = subscriberRepository;
	}

	@Override
	public List<Subscriber> findAll() {
		return subscriberRepository.findAll();
	}
	
	@Override
	public List<Subscriber> findByRegion(String Region) {
		
		return subscriberRepository.findByRegion(Region);
	}

	@Override
	public Subscriber findById(String id) {
		Optional<Subscriber> result = subscriberRepository.findById(id);

		Subscriber theControl = null;

		if (result.isPresent()) {
			theControl = result.get();
		} else {
			// we didn't find the trainer
			throw new RuntimeException("Did not find trainer id - " + id);
		}

		return theControl;
	}

	@Override
	public void save(Subscriber subscriber) {
		System.out.println("id from the service ");
		System.out.println(subscriber.toString());
		
		subscriberRepository.save(subscriber);

	}

	
	@Override
	public void deleteById(String theId) {
		subscriberRepository.deleteById(theId);

	}

	@Override
	public Subscriber updateSubscriber(Subscriber theSubscriber) {
		Subscriber newSubscriber = findById(theSubscriber.getId());
		newSubscriber.setEmail(theSubscriber.getEmail());
		newSubscriber.setPhoneNumber(theSubscriber.getPhoneNumber());
		newSubscriber.setGender(theSubscriber.getGender());
		newSubscriber.setFirstName(theSubscriber.getFirstName());
		newSubscriber.setLastName(theSubscriber.getLastName());
		newSubscriber.setBirthday(theSubscriber.getBirthday());
		newSubscriber.setHeight(theSubscriber.getHeight());
		newSubscriber.setWeight(theSubscriber.getWeight());
		save(newSubscriber);
		return newSubscriber;
	}


}
