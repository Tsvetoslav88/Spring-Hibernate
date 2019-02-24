package org.vexelon.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map to Java POJO
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first and last name
			System.out.println("First name: " + theStudent.getFirstName() + " Last name: " + theStudent.getLastName());
			
			// print out address: street and city
			Address tempAddress = theStudent.getAddress();
			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());
			
			// print out languages
			for(String laguage: theStudent.getLanguages()) {
				System.out.println(laguage);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
