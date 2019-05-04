package org.vexelon.springbootdemo.springbootapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

	// inject properties for: coach name and team name
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	// expose new endpoint for "teaminfo"
	@GetMapping("teaminfo")
	public String getTeamInfo() {
		return "Coach: " + coachName + ", Team name: " + teamName;
	}
	
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
