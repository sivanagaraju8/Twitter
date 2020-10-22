package com.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.twitter.model.User;
import com.twitter.repository.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User save(User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(new HashSet<>(roleRepository.findAll()));
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

	public User findById(Long id) {
		// TODO Auto-generated method stub
		 return userRepository.findById(id).get();
	}
	
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
