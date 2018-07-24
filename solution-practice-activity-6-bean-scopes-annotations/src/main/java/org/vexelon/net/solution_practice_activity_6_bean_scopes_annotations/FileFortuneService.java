package org.vexelon.net.solution_practice_activity_6_bean_scopes_annotations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "src/main/java/fortune-data.txt";
	private List<String> theFortunes;

	public FileFortuneService() {
		System.out.println(">> FileFortuneService: inside default constructor");
	}

	@PostConstruct
	public void loadTheFortunesFile() {
		System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");

		File file = new File(fileName);

		System.out.println("Reading fortunes from file: " + file);
		System.out.println("File exists: " + file.exists());

		theFortunes = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String tempLine;

			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(theFortunes.size());
		String tempFortune = theFortunes.get(index);

		return tempFortune;
	}

}
