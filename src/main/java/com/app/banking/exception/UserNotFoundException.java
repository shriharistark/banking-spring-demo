package com.app.banking.exception;

public class UserNotFoundException extends Exception {

    private static final String NO_USER_FOUND_FOR_THE_NAME_S = "no user found for the name %s";

    public UserNotFoundException(String customerName) {
        super(String.format(NO_USER_FOUND_FOR_THE_NAME_S, customerName));
    }

    public UserNotFoundException() {
        super();
    }
}
