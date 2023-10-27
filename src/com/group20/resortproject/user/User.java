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

    /**
     * 
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param dob
     * @param phone
     * @param credit
     */
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

    /**
     * 
     * @return user ID
     */
    public int getID() {
        return this.id;
    }

    /**
     * 
     * @return first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * 
     * @return last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * 
     * @return first and last name combination
     */
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * 
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 
     * @return date of birth
     */
    public LocalDate getDob() {
        return this.dob;
    }

    /**
     * 
     * @return phone number
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * 
     * @return users credit
     */
    public float getCredit() {
        return this.credit;
    }

    /**
     * 
     * @param pass adds a lift pass to the logged in user
     */
    public void addLiftPass(LiftPass pass) {
        this.passes.add(pass);
    }

    /**
     * 
     * @return true if the user has a valid lift pass, else returns false
     */
    public boolean hasValidPass() {
        for (LiftPass pass : passes) {
            if (pass.isValid()) {
                return true;
            }
        }

        return false;
    }

    /**
     * 
     * @return the valid lift pass of the logged in user, else returns null
     */
    public LiftPass getValidLiftPass() {
        for (LiftPass pass : passes) {
            if (pass.isValid()) {
                return pass;
            }
        }

        return null;
    }

    /**
     * 
     * @return ArrayList of liftPasses
     */
    public ArrayList<LiftPass> getLiftPasses() {
        return this.passes;
    }

    /**
     * charges the user the specified amount of credit
     * 
     * @param amount
     * @throws Exception
     */
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

    /**
     * adds all the users lift passes
     * 
     * @param list
     */
    void setLiftPasses(ArrayList<LiftPass> list) {
        this.passes = list;
    }

    /**
     * adds desired amount of credit to the users account
     * 
     * @param amount
     */
    void addCredit(float amount) {
        this.credit += amount;
    }

}
