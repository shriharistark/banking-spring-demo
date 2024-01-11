package com.app.banking.service;

import com.app.banking.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class PostCreation {

    public List<User> createUser(Scanner scanner) {

        List<User> users = new ArrayList<>();
        while(addUser(scanner)) {

            System.out.println("Enter user name :");
            String name = scanner.nextLine();

            User user = new User();
            user.setName(name);
            user.setAccountBalance(0D);

            users.add(user);
            System.out.println("user added");
        }

        return users;
    }

    private boolean addUser(Scanner scanner) {

        System.out.println("Create user : y/n");
        return scanner.nextLine().equals("y");
    }
}
