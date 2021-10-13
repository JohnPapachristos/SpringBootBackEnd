package com.example.ProjectSpring;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

//----------------------------------Before Testing my god, I must go to the User and change the table. I must put the table that I use for testing ---------------
//-------------------When all are ready, I do the same procedure backwards and run my app------------------------------------------------------------------



public class TestWebApp extends Testing {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void testGetOne() throws Exception {
		 
		//Testing getOne
		this.mockMvc.perform(MockMvcRequestBuilders.get("/Project/getOne/{id}",30)).andDo(print()).andExpect(status().isOk());
		
		
	}
	
	@Test
	public void testGet() throws Exception {
		 
		//Testing get
		this.mockMvc.perform(MockMvcRequestBuilders.get("/Project/get").accept(MediaType.APPLICATION_JSON)).andDo(print());
		
		
	}
	
	@Test
	public void testPost() throws Exception {
		User user = new User("GeorgE","ggg@g.ge","M",23);
		ObjectMapper Obj = new ObjectMapper(); 
		String jsonStr = Obj.writeValueAsString(user);  
		
		//Testing post
		this.mockMvc.perform(MockMvcRequestBuilders.post("/Project/create").content(jsonStr).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());	
		
		
	}
	
	@Test
	public void testPut() throws Exception {
		UserRequest userU = new UserRequest(30,"GeorgE","ggg@g.ge",23,"M");
		ObjectMapper Obj = new ObjectMapper();  
		String jsonStr1 = Obj.writeValueAsString(userU);  	
		
		//Testing put
		this.mockMvc.perform(MockMvcRequestBuilders.put("/Project/update").content(jsonStr1).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
		
	}
	
	

	
}