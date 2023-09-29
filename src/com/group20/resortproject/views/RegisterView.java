package com.group20.resortproject.views;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegisterView extends ViewPanel {
    
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dobStringField;
    private JTextField emailField;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private JButton submitButton;

    public RegisterView() {
        /**
         * setup
         */
        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        // This adds spacing between each field (in pixels)
        constraints.insets = new Insets(5, 0, 5, 0);

        int fieldColumns = 20;

        /**
         * Create components
         */
        this.firstNameField = new JTextField(fieldColumns);
        this.lastNameField = new JTextField(fieldColumns);
        this.dobStringField = new JTextField(fieldColumns);
        this.emailField = new JTextField(fieldColumns);
        this.phoneField = new JTextField(fieldColumns);
        this.passwordField = new JPasswordField(fieldColumns);
        this.submitButton = new JButton("Submit");

        /**
         * Add components
         */
        this.add(Box.createVerticalGlue());
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(new JLabel("First name: "), constraints);
        constraints.gridx++;
        this.add(firstNameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(new JLabel("Last name: "), constraints);
        constraints.gridx++;
        this.add(lastNameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(new JLabel("Date of birth: "), constraints);
        constraints.gridx++;
        this.add(dobStringField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        JLabel emaiLabel = new JLabel("Email: ");
        emaiLabel.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(emaiLabel, constraints);
        constraints.gridx++;
        this.add(emailField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        this.add(new JLabel("Phone number: "), constraints);
        constraints.gridx++;
        this.add(phoneField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        this.add(new JLabel("Password: "), constraints);
        constraints.gridx++;
        this.add(passwordField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        this.add(submitButton, constraints);
        this.add(Box.createVerticalGlue());

    }
}
