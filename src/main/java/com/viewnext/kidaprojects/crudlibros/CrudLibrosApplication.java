package com.viewnext.kidaprojects.crudlibros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.viewnext.kidaprojects.crudlibros.restcontroller",
		"com.viewnext.kidaprojects.crudlibros.service",
		"com.viewnext.kidaprojects.crudlibros.mapper",		
		"com.viewnext.kidaprojects.crudlibros.exception",
		"com.viewnext.kidaprojects.crudlibros.dto",
		"com.viewnext.kidaprojects.crudlibros.model" })
public class CrudLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudLibrosApplication.class, args);
	}

}
