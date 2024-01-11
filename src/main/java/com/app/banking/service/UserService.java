package com.app.banking.service;

import com.app.banking.entity.User;
import com.app.banking.exception.UserNotFoundException;
import com.app.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, Double initialBalance) {
        User user = new User();
        user.setName(name);
        user.setAccountBalance(initialBalance);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public double getBalance(String name) throws UserNotFoundException {

        User filteredUser = getUserByName(name);
        return filteredUser.getAccountBalance();
    }

    public User updateBalance(String name, double balance) throws UserNotFoundException {

        User filteredUser = getUserByName(name);
        filteredUser.setAccountBalance(balance);
        return userRepository.save(filteredUser);
    }

    private User getUserByName(String name) throws UserNotFoundException {

        List<User> users = getAllUsers();
        return users.stream()
                .filter(user -> name.equals(user.getName()))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(name));
    }
}