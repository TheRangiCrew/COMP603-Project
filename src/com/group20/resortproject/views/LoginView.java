package com.group20.resortproject.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.group20.resortproject.Main;
import com.group20.resortproject.controllers.Controller;

public class LoginView extends ViewPanel {

    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton submitButton;

    public LoginView() {
        /**
         * Setup
         */
        this.setSize(Main.size);
        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 0, 5, 0); // Padding between components

        int fieldColumns = 20;

        /**
         * Create Components
         */
        this.emailField = new JTextField(fieldColumns);
        this.passwordField = new JPasswordField(fieldColumns);
        this.submitButton = new JButton("Submit");
        submitButton.addMouseListener(null);

        /**
         * Add Components
         */
        this.add(Box.createVerticalGlue());
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(emailField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(passwordField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(submitButton, constraints);
        this.add(Box.createVerticalGlue());

    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void addController(Controller controller) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'addController'");
    }

}
