package com.c2p.h2.db;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.assertj.core.api.Assertions.assertThat;
import com.c2p.h2.controller.EmployeeController;
import com.c2p.h2.domain.EmployeeEntity;
import com.c2p.h2.repo.EmployeeRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class JUnitTestCaseForJPA {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	EmployeeRepository repository;

	@MockBean
	EmployeeController controller;

	@Test
	public void getAllEmployees() throws Exception {

	    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employees")
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	    System.out.println(result.getResponse().getContentAsString());
	}
	@Test
    public void testAddEmployee() throws Exception 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<EmployeeEntity> responseEntity1=new ResponseEntity<EmployeeEntity>(HttpStatus.OK);
        Mockito.when(controller.createOrUpdateEmployee(Mockito.any(EmployeeEntity.class))).thenReturn(responseEntity1);
        EmployeeEntity employee = new EmployeeEntity();
        employee.setId(9l);employee.setEmail("test@gmail.com");employee.setFirstName("Test");employee.setLastName("uma");
        ResponseEntity<EmployeeEntity> responseEntity = controller.createOrUpdateEmployee(employee);
        
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
       // assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }
	@Test
	public void getEmployee() throws Exception {
		MockHttpServletRequest request=new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<EmployeeEntity> responseEntity1=new ResponseEntity<EmployeeEntity>(HttpStatus.OK);
        Mockito.when(controller.getEmployeeById(1L)).thenReturn(responseEntity1);
        
		//employee.setId(1l);
		ResponseEntity<EmployeeEntity> responseEntity=controller.getEmployeeById(1l);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
}
