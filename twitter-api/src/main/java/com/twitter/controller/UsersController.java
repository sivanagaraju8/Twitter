package com.twitter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import com.twitter.exception.ResourceNotFoundException;
import com.twitter.model.User;



import com.twitter.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")	
@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UserService userService;
    
   @GetMapping
   public ResponseEntity<List<User>> findAll() {
       return ResponseEntity.ok(userService.findAll());
   }
	
   @GetMapping("/{id}")
   public ResponseEntity<User> findById(@PathVariable Long id) {
       @SuppressWarnings("unused")
	User user = userService.findById(id);

       return ResponseEntity.ok().body(user);
   }

   @PostMapping
	/*
	 * public ResponseEntity<String> postman() { return
	 * ResponseEntity.ok("Somehow it workded"); }
	 */
   @ResponseBody
	  public ResponseEntity<User> create(@Valid @RequestBody User user) { return
	  ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user)); }
	 
   
   @PutMapping("/{id}")
   @ResponseBody
   public ResponseEntity <User> update(@PathVariable Long id, @RequestBody User user) {
       return ResponseEntity.accepted().body(userService.save(user));
   }
  
    @SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws ResourceNotFoundException {
        userService.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
