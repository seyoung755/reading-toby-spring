package com.example.suntory;

public class Order {
    private String name;
    private String value;

    public Order(String userId, String password) {
        this.name = userId;
        this.value = password;
    }
}
