package org.vexelon.springbootdemo.springbootapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

	// expose "/" 
	@GetMapping("/")
	public String hello() {
		return "Hello world! Time on server is " + LocalDateTime.now();
	}
}
