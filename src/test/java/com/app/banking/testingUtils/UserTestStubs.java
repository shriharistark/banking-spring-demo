package com.app.banking.testingUtils;

import com.app.banking.entity.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserTestStubs {

    public static List<User> getTestUsers() {

        User user1 = new User();
        user1.setId(1);
        user1.setName("name1");
        user1.setAccountBalance(100.0);

        User user2 = new User();
        user2.setId(2);
        user2.setName("name2");
        user2.setAccountBalance(200.0);

        User user3 = new User();
        user3.setId(3);
        user3.setName("name3");
        user3.setAccountBalance(300.0);

        return Stream.of(user1, user2, user3).collect(Collectors.toList());
    }


}
