package com.group20.resortproject.gui.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.group20.resortproject.Controller;
import com.group20.resortproject.Main;
import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.controllers.LoginController;
import com.group20.resortproject.utility.ValidationException;

public class LoginView extends ViewPanel {

    private JLabel errorLabel;
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
        this.errorLabel = new JLabel();
        this.errorLabel.setForeground(Color.RED);
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
        constraints.gridwidth = 2;
        this.add(this.errorLabel, constraints);
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(new JLabel("Email: "), constraints);
        constraints.gridx++;
        this.add(emailField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(new JLabel("Password: "), constraints);
        constraints.gridx++;
        this.add(passwordField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridwidth = 2;
        this.add(submitButton, constraints);
        this.add(Box.createVerticalGlue());

    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void addController(Controller c) {
        
        LoginController controller = (LoginController) c;

        // Add an ActionListener to the submit button
        this.submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Submit the form to the controller
                    controller.login();
                    Navigator.goToPrev();

                } catch (ValidationException ex) {
                    // Set the error message
                    errorLabel.setText(ex.getMessage());
                }
            }
            
        });
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    
    
}
