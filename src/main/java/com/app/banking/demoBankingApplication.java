package com.app.banking;

import com.app.banking.entity.User;
import com.app.banking.service.UserService;
import com.app.banking.service.PostCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class demoBankingApplication {

	@Autowired
	private UserService userService;

	@Autowired
	private PostCreation postCreation;

	public static void main(String[] args) {

		SpringApplication.run(demoBankingApplication.class, args);
	}

	@PostConstruct
	public void setupDb() {

		userService.createUser("doe", 75.00D);
		List<User> inputUsers = postCreation.createUser(new Scanner(System.in));

		for(User x : inputUsers) {
			userService.createUser(x.getName(), x.getAccountBalance());
		}
	}
}
