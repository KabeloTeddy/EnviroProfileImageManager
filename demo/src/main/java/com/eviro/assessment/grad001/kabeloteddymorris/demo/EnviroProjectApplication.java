package com.eviro.assessment.grad001.kabeloteddymorris.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
//because it icludes the package where these classes are located, and Spring will handle the bean registration and injection for me.
@ComponentScan(basePackages = "com.eviro.assessment.grad001.kabeloteddymorris.demo")
public class EnviroProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EnviroProjectApplication.class, args);

		FileParserImpl fileParser = context.getBean(FileParserImpl.class);

		// Provide the CSV file I want to parse with its path depending on your machine
		File csvFile = new File("C:\\Users\\SeemelaT\\Downloads\\demo\\src\\main\\resources/file.csv");


		// Parse the CSV file and store records in the database
		fileParser.parseCSV(csvFile);

	}
}
