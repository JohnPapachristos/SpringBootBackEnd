package com.example.ProjectSpring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity // This makes a table with the values that are bellow
@JsonInclude(Include.NON_NULL)
@Table(name="user")
@JsonRootName(namespace="User",value = "Users")
@JsonPropertyOrder({"id", "username","email","gender","age"})
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  
  @JsonProperty("Username")
  @JsonRawValue
  @Column(name="username", nullable=false)
  private String username;
  
  @JsonProperty("Email")
  @Column(name="email", nullable=false)
  private String email;
  
  @JsonProperty("Gender")
  @Column(name="gender")
  private String gender;
  
  @JsonProperty("Age")
  @Column(name="age")
  private Integer age;
  
  @JsonProperty("Date and Time")
  @Column(name="date")
  private String date;

  @JsonProperty("password")
  @Column(name="password")
  private String password;
  
  public User() {
	  super();
  }
  
  public User(String username,String email,String gender,Integer age) {
	  this.username=username;
	  this.email=email;
	  this.gender=gender;
	  this.age=age;
  }
  
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getDate() {
	    return this.date;
	  }

  public void setDate(String date) {
	    this.date=date;
  }

  public String getUsername() {
    return this.username;
  }
  
  
  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public void setAge(Integer age) {
	    this.age = age;
  }
  
  public void setGender(String gender) {
	    this.gender = gender;
  }
  
  public Integer getAge(Integer age) {
	    return this.age;
  }
	
  public String getGender(String gender) {
	    return this.gender;
  }
  
  
  public void setPassword(String password) {
	  this.password=password;
  }
  
  public String getPassword() {
	  return this.password;
  }
  
}