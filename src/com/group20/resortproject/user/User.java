package com.group20.resortproject.user;

import java.time.LocalDate;
import java.util.ArrayList;

import com.group20.resortproject.lifts.LiftPass;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String phone;
    private float credit;
    private ArrayList<LiftPass> passes;

    public User(int id, String firstName, String lastName, String email, LocalDate dob, String phone, float credit) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
        this.credit = credit;
        this.passes = new ArrayList<>();
    }

    public int getID() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public String getPhone() {
        return this.phone;
    }

    public float getCredit() {
        return this.credit;
    }

    public void addLiftPass(LiftPass pass) {
        this.passes.add(pass);
    }

    public boolean hasValidPass() {
        for (LiftPass pass : passes) {
            if (pass.isValid()) {
                return true;
            }
        }

        return false;
    }

    public LiftPass getValidLiftPass() {
        for (LiftPass pass : passes) {
            if (pass.isValid()) {
                return pass;
            }
        }

        return null;
    }

    public ArrayList<LiftPass> getLiftPasses() {
        return this.passes;
    }

    public void chargeAccount(float amount) throws Exception {
        if (amount <= 0.0f) {
            throw new Exception("Amount to charge was less than or equal to zero. Payment failed");
        }

        if (amount > this.credit) {
            throw new Exception("Account has insufficient credit for this transaction.");
        }

        this.credit -= amount;

        try {
            UserModel.updateUser(this);
        } catch (Exception e) {
            throw e;
        }
    }

    void setLiftPasses(ArrayList<LiftPass> list) {
        this.passes = list;
    }

    void addCredit(float amount) {
        this.credit += amount;
    }

}
