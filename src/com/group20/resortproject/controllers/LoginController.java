package com.group20.resortproject.controllers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;

import com.group20.resortproject.data.Tuple;
import com.group20.resortproject.exception.ValidationException;
import com.group20.resortproject.models.LoginModel;
import com.group20.resortproject.models.Model;
import com.group20.resortproject.views.LoginView;
import com.group20.resortproject.views.View;

public class LoginController implements Controller {

    LoginModel model;
    LoginView view;

    private final String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public void login() throws ValidationException {
        String email = "";
        String password = "";

        try {
            email = this.view.getEmailField().getText();
            password = new String(this.view.getPasswordField().getPassword()).trim();
        } catch (NullPointerException e) {
        }

        if (email.isEmpty()) {
            throw new ValidationException("Your email is required!");
        }
        if (!(email.matches(emailRegex))) {
            throw new ValidationException("The email provided is not valid!");
        }

        if (password.isEmpty()) {
            throw new ValidationException("Please enter a password!");
        }

        // If all is successful, change button status
        JButton submitButton = this.view.getSubmitButton();
        submitButton.setEnabled(false);
        submitButton.setText("Checking...");

        Tuple<Integer, String> userData = model.login(email);

        int userID = userData.first.intValue();
        String dbPassword = userData.second;

        MessageDigest digest;

        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new ValidationException("Could not retrieve SHA digest");
        }

        byte[] dbPasswordBytes = dbPassword.getBytes(StandardCharsets.UTF_8);

        byte[] passwordBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        if(MessageDigest.isEqual(dbPasswordBytes, passwordBytes)) {
            System.out.println("Logged In...");
        } else {
            // If all is successful, change button status
            submitButton = this.view.getSubmitButton();
            submitButton.setEnabled(true);
            submitButton.setText("Submit");

            throw new ValidationException("Incorrect email or password...");
        }
    }

    @Override
    public void addModel(Model model) {
        this.model = (LoginModel) model;
    }

    @Override
    public void addView(View view) {
        this.view = (LoginView) view;
    }

}
