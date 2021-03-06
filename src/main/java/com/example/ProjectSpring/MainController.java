package com.example.ProjectSpring;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // This means that this class is a Controller
@RequestMapping("/User")
@ResponseBody
public class MainController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;

  
//----------------------Create values in my table----------------------------------
//Writing my url with /create in the end we can create values in our table usersss
  
  @PostMapping("/create")
  public ResponseEntity<Object> create(@RequestBody UserRequest data) throws Exception {
	  User user = new User();
	  PasswordHash pass = new PasswordHash();
	  try {
		  user.setUsername(data.getUsername());
		  user.setAge(data.getAge());
		  user.setEmail(data.getEmail());
		  user.setGender(data.getGender());
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		  LocalDateTime now = LocalDateTime.now();
		  pass.setPasswordToHash(data.getPassword());
		  user.setPassword(pass.getGeneratedPassword());
		  user.setDate(dtf.format(now));
		  return ResponseEntity.ok(userRepository.save(user));
	  }
	  catch(DataIntegrityViolationException ex) {
		  final String message1 = "Not null values OR Username exists OR Email exists";
		  final String message2 = " "+ex.getMostSpecificCause();
		  data.setError(message1);
		  data.setSpeError(message2);
		  return  ResponseEntity.ok(data);
	  }
	  
	 
  }

  
//----------------------Update values in my table -----------------------------------
//Writing my url with /update in the end we can update values in our table users

  @PutMapping("/update")
  public ResponseEntity<Object> update (@RequestBody UserRequest data) {
	 User user = userRepository.findById(data.getId()).orElse(null); 
	 try {
		 if(user != null) {
			  user.setUsername(data.getUsername());
			  user.setAge(data.getAge());
			  user.setEmail(data.getEmail());
			  user.setGender(data.getGender());
			  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			  LocalDateTime now = LocalDateTime.now();  
			  user.setDate(dtf.format(now));
			  return ResponseEntity.ok(userRepository.save(user));
		 }
		 else {
			 return ResponseEntity.ok(user);
		 }
	 }
	 catch(DataIntegrityViolationException ex) {
		 
		 final String message1 = "Not null values OR Username exists OR Email exists";
		 final String message2 = " "+ex.getMostSpecificCause();
		 data.setError(message1);
		 data.setSpeError(message2);
		 return  ResponseEntity.ok(data);
	     
	 }
	 
  }
 
//----------------------Delete values in my table----------------------------------
// Writing my url with /delete in the end we can delete values from our table users
 
  	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete (@PathVariable int id) {
		 User user = userRepository.findById(id).orElse(null);
		 UserRequest data = new UserRequest();
		 if(user != null) {
			 userRepository.deleteById(id);
			 String message = "Deleted value with the id: "+id;
			 data.setMessage(message);
			 return ResponseEntity.ok(data);
		 }
		 else {
			 String message = "Error this id: "+id+" "+"has no matches";
			 data.setError(message);
			 return ResponseEntity.ok(data);
		 }
	}
	
//----------------------Get values in my table----------------------------------
//Writing my url with /get in the end we can print values in our website or postman (localhost and port 8080)
	@GetMapping("/read")
	public List<User> read (@RequestBody UserRequest data) {
		
		if(data.getUsername() != null) {
			return userRepository.findByUsername(data.getUsername());
		}
		else if(data.getEmail() != null) {
			return userRepository.findByEmail(data.getEmail());
		}
		else if( (data.getEmail() != null) && (data.getUsername() != null) ) {
			return userRepository.findByUsernameAndEmail(data.getUsername(), data.getEmail());
		}
		else {
			return userRepository.findAll();     
		}
	}

	@GetMapping("/read/{id}") 
	public ResponseEntity<Object> readById (@PathVariable Integer id) {
		User user = userRepository.findById(id).orElse(null);
		UserRequest data = new UserRequest();
		if(user != null) {
			return ResponseEntity.ok(data);
		}
		else {
			String message = "This id: "+id+" has no matches";
			data.setMessage(message);
			return ResponseEntity.ok(data);
		}
		
	}

}
