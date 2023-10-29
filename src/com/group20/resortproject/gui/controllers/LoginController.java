package com.group20.resortproject.gui.controllers;

import javax.swing.JButton;

import com.group20.resortproject.Controller;
import com.group20.resortproject.View;
import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.Page;
import com.group20.resortproject.gui.views.LoginView;
import com.group20.resortproject.user.UserController;
import com.group20.resortproject.utility.ValidationException;

public class LoginController implements Controller {

    LoginView view;

    private final String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public void login() throws ValidationException {
        String email = "";
        String password = "";

        try {
            email = this.view.getEmailField().getText().toLowerCase();
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

        // If a user login attempt is successful...
        if (UserController.login(email, password)) {
            System.out.println("Logged in...");
            Navigator.goTo(Page.HOME);
            Navigator.resetPrevious();
        } else {
            // If all is unsuccessful, change button status
            submitButton = this.view.getSubmitButton();
            submitButton.setEnabled(true);
            submitButton.setText("Submit");

            throw new ValidationException("Incorrect email or password...");
        }
    }

    @Override
    public void addView(View view) {
        this.view = (LoginView) view;
    }

}
