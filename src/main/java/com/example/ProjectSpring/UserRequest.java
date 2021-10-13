package com.example.ProjectSpring;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonRootName(value="Users")
@JsonInclude(Include.NON_NULL)
public class UserRequest {
	
	private Integer id;
	
	private String username;
	
	private String email;
	
	private Integer age;
	
	private String gender;
	
	private String date;
	
	private String error;
	
	private String password;
	
	private String speError;
	
	private String message;
	
	public UserRequest(Integer id,String username,String email,Integer age, String gender) {
		this.id=id;
		this.username=username;
		this.email=email;
		this.age=age;
		this.gender=gender;
	}
	
	public UserRequest() {
		super();
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setDate(String date) {
		this.date=date;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setAge(Integer age) {
		this.age=age;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setError(String error) {
		this.error=error;
	}
	
	public String getError() {
		return this.error;
	}
	
	public void setSpeError(String speError) {
		this.speError=speError;
	}
	
	public String getSpeError() {
		return this.speError;
	}
	
	public void setMessage(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getPassword() {
		return this.password;
	}
}
