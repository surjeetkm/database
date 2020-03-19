package com.c2p.h2.db;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = H2DbinstanceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class IntegrationTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void getAllEmployees() throws Exception {
		MvcResult result=	mockMvc.perform(MockMvcRequestBuilders.get("/employees/").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println("==================================="+result.getResponse().getContentAsString());
	}
	@Test
	public void getEmployee() throws Exception {
		MvcResult result=	mockMvc.perform(MockMvcRequestBuilders.get("/employees/7").accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println("========================================"+result.getResponse().getContentAsString());
	}
	@Test
	public void postTest() throws Exception {
		String json="{\"firstName\":\"Gadho\",\"lastName\":\"londa\",\"email\":\"godho@gmail.com\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType("application/json;charset=UTF-8"));
		 
	}
	/*
	 * @Test public void deleteTest() throws Exception { MvcResult result=
	 * mockMvc.perform(MockMvcRequestBuilders.delete("/employees/id/8").accept(
	 * MediaType.APPLICATION_JSON)).andReturn();
	 * System.out.println("========================================"+result.
	 * getResponse().getContentAsString()); }
	 */
	
}
