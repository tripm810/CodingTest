package com.coding.test;

import org.junit.Test;
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


@RunWith(SpringRunner.class)
@SpringBootTest(
			webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
			classes = TestApplication.class
		)
@AutoConfigureMockMvc
@TestPropertySource(locations = "file:src/main/resources/application.properties")
public class SpringDataJpaTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void findAll() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/findall").accept(MediaType.APPLICATION_JSON)
				).andReturn();
		System.out.println(mvcResult.getResponse());
		
	}
	@Test
	public void findbyId() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/find/1").accept(MediaType.APPLICATION_JSON)
				).andReturn();
		System.out.println(mvcResult.getResponse());
	}

}
