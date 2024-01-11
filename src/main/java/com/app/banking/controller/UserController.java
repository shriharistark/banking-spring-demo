package com.app.banking.controller;

import com.app.banking.entity.User;
import com.app.banking.exception.UserNotFoundException;
import com.app.banking.response.UserResponse;
import com.app.banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /***
     * Retrieve all the users
     * @return list of users
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public UserResponse getAllUsers() {

        List<User> users = userService.getAllUsers();
        return new UserResponse.UserBuilder().setUsers(users).build();
    }

    /***
     * Retrieve balance for the user with the given name
     * @param name
     * @return user balance
     * @throws UserNotFoundException
     */
    @RequestMapping(value = "/{name}/balance", method = RequestMethod.GET)
    public UserResponse getUserBalanceByName(@PathVariable String name) {
        try {
            Double balance = userService.getBalance(name);
            return new UserResponse.UserBuilder().setBalance(balance).setName(name).build();
        } catch (UserNotFoundException e) {
            return new UserResponse.UserBuilder().setError("user not found with name "+name).build();
        }
    }

    /***
     * update balance for the given user
     * @param name
     * @param balance
     * @return user with updated balance
     * @throws UserNotFoundException
     */
    @RequestMapping(value = "/{name}/balance/{balance}", method = RequestMethod.PUT)
    public UserResponse updateUserBalanceByName(@PathVariable String name, @PathVariable double balance) {
        try {
            User user = userService.updateBalance(name, balance);
            return new UserResponse.UserBuilder().setUser(user).build();
        } catch (UserNotFoundException e) {
            return new UserResponse.UserBuilder().setError("user not found with name "+name).build();
        }

    }
}