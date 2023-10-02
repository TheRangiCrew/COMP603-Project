package com.group20.resortproject.user;

import java.time.LocalDate;

public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String phone;

    public User(int id, String firstName, String lastName, String email, LocalDate dob, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
    }

    

}
