package com.clouway.testing.task6;

public interface UserDB {
    boolean Register(User user);
    boolean getRegisteredUser(String name);
}
