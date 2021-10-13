package com.example.ProjectSpring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
// in this i write my queries that i handle in my controller
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByUsernameAndEmail(String name,String email);
	public List<User> findByUsername(String name);
	public List<User> findByEmail(String email);
	
}