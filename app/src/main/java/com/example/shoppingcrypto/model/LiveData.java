package com.example.shoppingcrypto.model;

public class LiveData {
    private static LiveData instance;

    public static LiveData newInstance() {
        if (instance == null) {
            instance = new LiveData();
        }
        return instance;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
