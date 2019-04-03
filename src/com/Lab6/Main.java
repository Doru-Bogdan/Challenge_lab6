package com.Lab6;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileSystemUserRepository repo = new FileSystemUserRepository("/Users/dorumancila/Desktop/Lab6_JAVA/src/com/Lab6/Repo");
        ArrayList<User> users = repo.findAll();
//        System.out.println(users.get(0));
//        System.out.println(users);
        System.out.println(repo.login(1234,"parola"));
        System.out.println(repo.findByUserType(UserType.ADMIN));
    }
}
