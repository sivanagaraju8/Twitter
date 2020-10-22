package com.twitter.controller;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.twitter.model.Tweet;
import com.twitter.model.User;
import com.twitter.service.TweetService;
import com.twitter.service.UserService;

	
@RestController
@RequestMapping("/api/tweets")
public class TweetsController {
    @Autowired
    private TweetService tweetService;
   @GetMapping
   public ResponseEntity<List<Tweet>> findAll() {
       return ResponseEntity.ok(tweetService.findAll());
   }
	
   @GetMapping("/{userId}")
   public ResponseEntity<ListIterator<Tweet>> findById(@PathVariable String userId) {
       @SuppressWarnings("unused")
	List<Tweet> user = tweetService.findByUserId(userId);
       
      
       return ResponseEntity.ok(tweetService.findByUserId(userId).listIterator());
   }

   @PostMapping
	
	  public ResponseEntity<Tweet> create( Tweet tweet) { return
	  ResponseEntity.status(HttpStatus.CREATED).body(tweetService.save(tweet)); }
	 
   
   @PutMapping("/{id}")
   @ResponseBody
   public ResponseEntity <Tweet> update(@PathVariable Long id, @RequestBody Tweet tweet) {
       return ResponseEntity.accepted().body(tweetService.save(tweet));
   }
  
    @SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        tweetService.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
