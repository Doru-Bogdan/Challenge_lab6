package com.Lab6;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> findAll();
    User login(long ID, String password) throws UserNotFoundException;
    ArrayList<User> findByUserType(UserType userType);
}
