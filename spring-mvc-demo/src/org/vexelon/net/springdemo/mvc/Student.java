package org.vexelon.net.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String contry;
	
	private LinkedHashMap<String, String> countryOption;
	
	public Student() {
		
		//populate country options: used ISO country code
		countryOption = new LinkedHashMap<>();
		countryOption.put("BR", "Brazil");
		countryOption.put("FR", "France");
		countryOption.put("DE", "Germany");
		countryOption.put("IN", "India");
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public LinkedHashMap<String, String> getCountryOption() {
		return countryOption;
	}
	
	
	
}
