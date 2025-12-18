package com.pack.api;

import com.pack.api.common.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaMappingsApplication implements CommandLineRunner {


	@Autowired
	AppService appService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaMappingsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// appService.saveData();

		// appService.fetchData();

		// appService.getStudentFromAddress();

		appService.getStudentFromAddress1();

	}


}
