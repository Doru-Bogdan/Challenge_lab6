package com.Lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSystemUserRepository implements UserRepository {

    private String path;
    private ArrayList<User> buffer;

    public FileSystemUserRepository(String path) throws FileNotFoundException {
        buffer = new ArrayList<>();
        this.path = path;
        Scanner scan = new Scanner(new File(path));
        while(scan.hasNext()) {
            UserType userType = null;
            long ID = scan.nextLong();
            String password = scan.next();
            String type = scan.next();
            if (type.equals("ADMIN"))
                userType = UserType.ADMIN;
            else if (type.equals("SUPER_ADMIN"))
                userType = UserType.SUPER_ADMIN;
            else if (type.equals("NORMAL_USER"))
                userType = UserType.NORMAL_USER;
            User temp = new User(ID, password, userType);
            buffer.add(temp);
        }
    }

    @Override
    public ArrayList<User> findAll() {
        return this.buffer;
    }

    @Override
    public User login(long ID, String password) throws UserNotFoundException {
        for (User user : buffer) {
            long tempID = user.getID();
            String tempPassword = user.getPassword();
            if (tempID == ID && tempPassword.equals(password))
                return user;
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public ArrayList<User> findByUserType(UserType userType) {
        ArrayList<User> array = new ArrayList<>();
        for (User user : buffer) {
            if (user.getType().equals(userType))
                array.add(user);
        }
        return array;
    }
}
