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
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucy day";
	}
}
