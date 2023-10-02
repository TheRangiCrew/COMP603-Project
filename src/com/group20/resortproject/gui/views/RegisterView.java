package com.group20.resortproject.gui.views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.group20.resortproject.Controller;
import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.controllers.RegisterController;
import com.group20.resortproject.utility.ValidationException;

public class RegisterView extends ViewPanel {
    
    private JLabel errorLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dobStringField;
    private JTextField emailField;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private JPasswordField confirmationField;
    private JButton submitButton;

    public RegisterView() {
        /**
         * setup
         */
        this.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        // This adds spacing between each field (in pixels)
        constraints.insets = new Insets(5, 2, 5, 2);

        int fieldColumns = 25;

        /**
         * Create components
         */
        this.errorLabel = new JLabel();
        this.errorLabel.setForeground(Color.RED);
        this.firstNameField = new JTextField(fieldColumns);
        this.lastNameField = new JTextField(fieldColumns);
        this.dobStringField = new JTextField(fieldColumns);
        this.emailField = new JTextField(fieldColumns);
        this.phoneField = new JTextField(fieldColumns);
        this.passwordField = new JPasswordField(fieldColumns);
        this.confirmationField = new JPasswordField(fieldColumns);
        this.submitButton = new JButton("Submit");

        /**
         * Add components
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
        this.add(new JLabel("First name: "), constraints);
        constraints.gridx++;
        this.add(firstNameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(new JLabel("Last name: "), constraints);
        constraints.gridx++;
        this.add(lastNameField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        this.add(new JLabel("Date of birth: "), constraints);
        constraints.gridx++;
        this.add(dobStringField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 4;
        JLabel emaiLabel = new JLabel("Email: ");
        emaiLabel.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(emaiLabel, constraints);
        constraints.gridx++;
        this.add(emailField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        this.add(new JLabel("Phone number: "), constraints);
        constraints.gridx++;
        this.add(phoneField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 6;
        this.add(new JLabel("Password: "), constraints);
        constraints.gridx++;
        this.add(passwordField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 7;
        this.add(new JLabel("Confirm password: "), constraints);
        constraints.gridx++;
        this.add(confirmationField, constraints);
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(submitButton, constraints);
        this.add(Box.createVerticalGlue());

    }

    public JTextField getFirstNameField() {
        return this.firstNameField;
    }

    public JTextField getLastNameField() {
        return this.lastNameField;
    }

    public JTextField getDobStringField() {
        return this.dobStringField;
    }

    public JTextField getEmailField() {
        return this.emailField;
    }

    public JTextField getPhoneField() {
        return this.phoneField;
    }

    public JPasswordField getPasswordField() {
        return this.passwordField;
    }

    public JPasswordField getConfirmationField() {
        return this.confirmationField;
    }

    public JButton getSubmitButton() {
        return this.submitButton;
    }

    /**
     * Add a provided controller to be used as an Observer
     */
    @Override
    public void addController(Controller c) {
        // Type-cast the controller to the correct controller
        RegisterController controller = (RegisterController) c;

        // Add an ActionListener to the submit button
        this.submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Submit the form to the controller
                    controller.submit();

                    JOptionPane.showMessageDialog(null, "Your account has been registered! You can login straight away by clicking \"Login\" on the Welcome page.");

                    Navigator.goToPrev();
                } catch (ValidationException ex) {
                    errorLabel.setText(ex.getMessage());
                }
            }
            
        });
    }

}
