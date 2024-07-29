package com.pragma.mutant.mutantapp;


import com.pragma.mutant.mutantapp.util.Constants;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = Constants.BASE_PACKAGES_REPOSITORY)
public class MutantAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutantAppApplication.class, args);
	}

}
