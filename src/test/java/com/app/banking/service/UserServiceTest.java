package com.app.banking.service;

import com.app.banking.entity.User;
import com.app.banking.exception.UserNotFoundException;
import com.app.banking.repository.UserRepository;
import com.app.banking.testingUtils.UserTestStubs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.times;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        Mockito.when(userRepository.findAll()).thenReturn(UserTestStubs.getTestUsers());
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(UserTestStubs.getTestUsers().get(0));
    }

    @Test
    public void getAllUsersTest() {

        List<User> users = userService.getAllUsers();
        Mockito.verify(userRepository, times(1)).findAll();
        Assert.assertEquals("should equal total number of entities in db",
                UserTestStubs.getTestUsers().size(), users.size());
    }

    @Test
    public void getUserBalanceTest() throws UserNotFoundException {

        double userBalance = userService.getBalance("name1");
        Assert.assertTrue(Double.compare(100.0d, userBalance) == 0);
    }

    @Test(expected = UserNotFoundException.class)
    public void getUserBalanceWhenUserNotFoundTest() throws UserNotFoundException {
        userService.getBalance("name5");
    }

    @Test
    public void updateUserBalanceTest() throws UserNotFoundException {

        double balanceToUpdate = 1000.50;
        userService.updateBalance("name1", balanceToUpdate);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userRepository, times(1)).save(userArgumentCaptor.capture());
        Assert.assertTrue(Double.compare(balanceToUpdate,
                userArgumentCaptor.getValue().getAccountBalance()) == 0);
    }

    @Test(expected = UserNotFoundException.class)
    public void updateUserBalanceWhenUserNotFoundTest() throws UserNotFoundException {

        double balanceToUpdate = 1000.50;
        userService.updateBalance("name5", balanceToUpdate);
    }

}
