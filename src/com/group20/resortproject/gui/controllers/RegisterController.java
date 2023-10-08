package com.group20.resortproject.gui.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JButton;

import com.group20.resortproject.Controller;
import com.group20.resortproject.Model;
import com.group20.resortproject.View;
import com.group20.resortproject.gui.views.RegisterView;
import com.group20.resortproject.user.UserController;
import com.group20.resortproject.utility.ValidationException;

public class RegisterController implements Controller {

    RegisterView view; // Reference to the view

    String nameRegex = "^[A-Za-z\\-\\.]+$"; // Allows only alphabetic characters and hyphens (-)
    String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" // Allows only a valid email structure (example@example.com)
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    String phoneRegex = "^\\+?\\d+$"; // Only allows digits and +


    public void submit() throws ValidationException {

    String firstName = "";
    String lastName = "";
    String dob = "";
    LocalDate dobDate;
    String email = "";
    String phone = "";
    String password = "";
    String confirmation ="";
    
    try {
        firstName = this.view.getFirstNameField().getText();
        lastName = this.view.getLastNameField().getText();
        dob = this.view.getDobStringField().getText();
        email = this.view.getEmailField().getText().toLowerCase();
        phone = this.view.getPhoneField().getText();
        password = new String(this.view.getPasswordField().getPassword());
        confirmation = new String(this.view.getConfirmationField().getPassword());
    } catch (NullPointerException e) {}
    

        if (firstName.isEmpty()) {
            throw new ValidationException("Your first name is required!");
        } else if (!(firstName.matches(nameRegex))) {
            throw new ValidationException("Your name can only contain letters and hyphens");
        }

        if (lastName.isEmpty()) {
            throw new ValidationException("Your last name is required!");
        } else if (!(lastName.matches(nameRegex))) {
            throw new ValidationException("Your name can only contain letters and hyphens");
        }

        if (dob.isEmpty()) {
            throw new ValidationException("Your DOB is required!");
        }
        try {
            dobDate = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            throw new ValidationException("The DOB entered was not valid!");
        }

        if (email.isEmpty()) {
            throw new ValidationException("Your email is required!");
        }
        if (!(email.matches(emailRegex))) {
            throw new ValidationException("The email provided is not valid!");
        }
        
        if (phone.isEmpty()) {
            throw new ValidationException("Your phone number is required!");
        } else if (!(phone.matches(phoneRegex))) {
            throw new ValidationException("The phone number provided was not formatted correctly");
        }
        
        if (password.isEmpty()) {
            throw new ValidationException("Please create a password!");
        }
        if(confirmation.isEmpty()) {
            throw new ValidationException("Please confirm your password!");
        } else if (!(confirmation.matches(password))) {
            throw new ValidationException("Your passwords do not match!");
        }

        // If all is successful, change button status
        JButton submitButton = this.view.getSubmitButton();
        submitButton.setEnabled(false);
        submitButton.setText("Registering...");

        UserController.addUser(firstName, lastName, dobDate, email, phone, password);
        
    }


    @Override
    public void addModel(Model model) {
    }


    @Override
    public void addView(View view) {
        this.view = (RegisterView) view;
    }

    

}
