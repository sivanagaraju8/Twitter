package com.twitter.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
    private String firstName;
    private String lastName;
    private String country;
   

	@Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;

    public User(){}



    public User(String username, Long id, String password, String firstName, String lastName, String country) {
        super();
        this.username=username;
        this.id=id;
        this.password=password;
        this.country=country;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public Long getId() {
        return id;
    }
    

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="username",nullable=false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="password", nullable=false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name="first_Name",nullable=false)
    public String getFirstName() {
        return firstName;
    }
   
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name="last_Name",nullable=false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    @Column(name="country",nullable=false)
    public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
