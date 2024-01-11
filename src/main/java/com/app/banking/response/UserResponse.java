package com.app.banking.response;

import com.app.banking.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private String name;
    private Double balance;
    private List<User> users;
    private List<String> errors;

    private UserResponse(UserBuilder builder) {
        this.name = builder.name;
        this.balance = builder.balance;
        this.users =builder.users;
        this.errors = builder.errors;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<String> getErrors() {
        return errors;
    }

    //Builder Class
    public static class UserBuilder {

        // required parameters
        private String name;
        private Double balance;
        private List<User> users;
        private List<String> errors;

        public UserBuilder(){}

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setBalance(Double balance) {
            this.balance = balance;
            return this;
        }

        public UserBuilder setUsers(List<User> users) {
            this.users = users;
            return this;
        }

        public UserBuilder setUser(User user) {
            this.users = Stream.of(user).collect(Collectors.toList());
            return this;
        }

        public UserBuilder setError(String error) {
            this.errors = Stream.of(error).collect(Collectors.toList());
            return this;
        }

        public UserBuilder setError(List<String> errors) {
            this.errors = errors;
            return this;
        }

        public UserResponse build(){
            return new UserResponse(this);
        }

    }
}
