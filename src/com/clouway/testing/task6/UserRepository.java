package com.clouway.testing.task6;

public class UserRepository { // Service class
    private UserDB userDB;
    private Validator validator;

    public UserRepository(UserDB userDB, Validator validator) {
        this.userDB = userDB;
        this.validator = validator;
    }

    public void registerUser(User user) {
        if(validator.isValid(user.getAge())){
            userDB.Register(user);
        }
    }

    public boolean isAdult(String name) throws UserDoesNotExistException {
        if(userDB.getRegisteredUser(name)){
            return true;
        }else{
            throw new UserDoesNotExistException();
        }
    }

}
