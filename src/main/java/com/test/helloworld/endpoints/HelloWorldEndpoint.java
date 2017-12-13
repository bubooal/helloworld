package com.test.helloworld.endpoints;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldEndpoint {

	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.TEXT_HTML_VALUE
			)
	public String helloWorld() {
		return "Hello World!";
	}
	
}
