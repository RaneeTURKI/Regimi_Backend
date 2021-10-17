package com.eniso.regimi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.eniso.regimi.repository.UserRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableMongoRepositories
@EnableSwagger2


public class RegimiApplication {
	@Autowired
    UserRepository userRepo;

	public static void main(String[] args) {
		SpringApplication.run(RegimiApplication.class, args);
	}

}
