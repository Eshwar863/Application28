package com.example.application28.DTO;

public class UserPaidUnPaid {
    private String name;
    private String phoneNumber;
    private String id;

    public UserPaidUnPaid(String name, String phoneNumber, String id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getId() {
        return id;
    }
}
