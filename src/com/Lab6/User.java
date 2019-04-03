package com.Lab6;

public class User {
    private long ID;
    private String password;
    private UserType type;

    public User(long ID, String password, UserType type) {
        this.ID = ID;
        this.password = password;
        this.type = type;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public long getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    @Override
    public String toString() {
        return("User: " + this.ID + " type " + this.type);
    }
}
