package com.test.helloworld.endpoints;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldEndpoint.class, secure = false)
public class HelloWorldEndpointTest {

	
	@Autowired
	protected MockMvc mockMvc;
	
	private static final String ENDPOINT_URI = "/helloworld";
	
	@Test
	public void helloWorldValidTest() throws Exception {
		
		RequestBuilder requestBuilder;
		MvcResult result;
		MockHttpServletResponse response;
		
		requestBuilder = MockMvcRequestBuilders.get(ENDPOINT_URI)
				.accept(MediaType.TEXT_HTML_VALUE);
		
		result = mockMvc.perform(requestBuilder).andReturn();
		
		response = result.getResponse();
		
		assertEquals(response.getContentAsString(), "Hello World!");
		
	}
	
}
