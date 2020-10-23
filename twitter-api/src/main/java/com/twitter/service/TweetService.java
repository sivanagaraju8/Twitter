package com.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.model.Tweet;
import com.twitter.repository.TweetRepository;

@Service 
public class TweetService{
			
	@Autowired
	private TweetRepository tweetRepository;
	
	    public Tweet save(Tweet tweets) {
	    	return tweetRepository.save(tweets);
	 }
	 
	public List<Tweet> findByUserId(String username) {
		return tweetRepository.findByUserId(username);
	}

	public List<Tweet> findAll() {
		 return tweetRepository.findAll();
	}

	public void deleteById(Long id) {
		 tweetRepository.deleteById(id);
		
	}

	public Tweet findById(Long id) {
		// TODO Auto-generated method stub
		return  tweetRepository.findById(id).get();
	}
}
