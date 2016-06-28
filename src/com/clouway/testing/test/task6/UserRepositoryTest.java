package com.clouway.testing.test.task6;


import com.clouway.testing.task6.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class UserRepositoryTest {
    @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
    Validator validator = context.mock(Validator.class);
    UserDB userDB = context.mock(UserDB.class);
    UserRepository userRepository = new UserRepository(userDB,validator);

    @Test
    public void userIsAdult(){ // Happy path
        User adultUser = new User("Borislav","21");
        context.checking(new Expectations(){{
                oneOf(validator).isValid("21");
                will(returnValue(true));

                oneOf(userDB).Register(adultUser);
                will(returnValue(true));
        }});
        userRepository.registerUser(adultUser);
    }

    @Test
    public void userIsNotAdult(){
        User adultUser = new User("Borislav","13");
        context.checking(new Expectations(){{
            oneOf(validator).isValid("13");
            will(returnValue(false));
        }});
        userRepository.registerUser(adultUser);
    }

    @Test
    public void userDoesExist() throws UserDoesNotExistException {
        User adultUser = new User("Borislav","21");
        context.checking(new Expectations(){{
            oneOf(validator).isValid("21");
            will(returnValue(true));

            oneOf(userDB).Register(adultUser);
            will(returnValue(true));

            oneOf(userDB).getRegisteredUser("Borislav");
            will(returnValue(true));
        }});
        userRepository.registerUser(adultUser);
        userRepository.isAdult("Borislav");
    }

    @Test(expected = UserDoesNotExistException.class)
    public void userDoesNotExist() throws UserDoesNotExistException {
        User adultUser = new User("Borislav","21");
        context.checking(new Expectations(){{
            oneOf(validator).isValid("21");
            will(returnValue(true));

            oneOf(userDB).Register(adultUser);
            will(returnValue(true));

            oneOf(userDB).getRegisteredUser("Georgi");
            will(returnValue(false));
        }});
        userRepository.registerUser(adultUser);
        userRepository.isAdult("Georgi");
    }
}
