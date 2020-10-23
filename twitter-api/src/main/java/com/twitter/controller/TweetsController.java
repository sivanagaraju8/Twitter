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

@CrossOrigin(origins = "http://localhost:4200")	
@RestController
@RequestMapping("/api/tweets")
public class TweetsController {
    @Autowired
    private TweetService tweetService;
   @GetMapping
   public ResponseEntity<List<Tweet>> findAll() {
       return ResponseEntity.ok(tweetService.findAll());
   }
	
	/*
	 * @GetMapping("/{userId}") public ResponseEntity<List<Tweet>>
	 * findByUserId(@PathVariable String userId) {
	 * 
	 * @SuppressWarnings("unused") List<Tweet> tweet =
	 * tweetService.findByUserId(userId); return
	 * ResponseEntity.ok(tweetService.findByUserId(userId)); }
	 */
   @GetMapping("/{id}")
   public ResponseEntity<Tweet> findById(@PathVariable Long id) {
	   
     //  @SuppressWarnings({ "unused", "unchecked" })
	/*List<Tweet> tweet = (List<Tweet>) tweetService.findById(id);*/
       return ResponseEntity.ok(tweetService.findById(id));
   }

   @PostMapping
   @ResponseBody
	  public ResponseEntity<Tweet> create( @RequestBody Tweet tweet) { return
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
