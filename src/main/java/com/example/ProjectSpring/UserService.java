package com.example.ProjectSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User>  list(){
		return userRepository.findAll();
	}
	
}
