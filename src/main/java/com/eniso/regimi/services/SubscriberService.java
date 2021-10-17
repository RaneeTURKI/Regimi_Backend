package com.eniso.regimi.services;

import java.util.List;

import com.eniso.regimi.models.Subscriber;


public interface SubscriberService {
	public List<Subscriber> findAll();

	public Subscriber findById(String theId);
	public List<Subscriber> findByRegion(String Region);

	public void save(Subscriber subscriber);

	
	public void deleteById(String theId);

	Subscriber updateSubscriber(Subscriber theTrainer);
	

}
