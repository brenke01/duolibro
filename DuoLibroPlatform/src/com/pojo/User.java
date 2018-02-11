package com.pojo;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
	  @Id @GeneratedValue
	  @Column(name = "user_id")
	  private Long userID;
	  
	  @Column(name = "username")
	  private String username;
	  
	  @Column(name = "password")
	  private String password;

	  @Column(name = "first_name")
	  private String firstname;
	  
	  @Column(name = "last_name")
	  private String lastname;
	  
	  @Column(name = "email")
	  private String email;
	  
	  public Long getUserID() {
		  return userID;
	  }
	  public void setUserID(Long userID) {
		  this.userID = userID;
	  }
	  
	  public String getUsername() {
		  return username;
	  }
	  public void setUsername(String username) {
		  this.username = username;
	  }
	  public String getPassword() {
		  return password;
	  }
	  public void setPassword(String password) {
		  this.password = password;
	  }
	  public String getFirstname() {
		  return firstname;
	  }
	  public void setFirstname(String firstname) {
		  this.firstname = firstname;
	  }
	  public String getLastname() {
		  return lastname;
	  }
	  public void setLastname(String lastname) {
		  this.lastname = lastname;
	  }
	  public String getEmail() {
		  return email;
	  }
	  public void setEmail(String email) {
		  this.email = email;
	  }

	}