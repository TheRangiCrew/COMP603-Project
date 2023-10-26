package com.group20.resortproject.gui.views.creditpass;

import com.group20.resortproject.Controller;
import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.controllers.creditpass.CreditController;
import com.group20.resortproject.gui.views.ViewPanel;
import com.group20.resortproject.user.UserController;
import com.group20.resortproject.utility.ValidationException;

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
import javax.swing.JTextField;

public class CreditView extends ViewPanel {

    private JLabel label;
    private JTextField field;
    private JButton submit;

    public CreditView() {
        /**
         * Setup
         */
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 0, 10, 0);

        /**
         * Create Components
         */
        this.label = new JLabel("Enter the dollar ($) value of the credit you wish to add: ");

        this.field = new JTextField(20);

        this.submit = new JButton("Add Credit");

        /**
         * Group Components
         */
        this.add(Box.createVerticalGlue());
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(this.label, constraints);
        constraints.gridy++;
        this.add(this.field, constraints);
        constraints.gridy++;
        this.add(this.submit, constraints);
        this.add(Box.createVerticalGlue());
    }

    public void addController(Controller c) {
        CreditController controller = (CreditController) c;

        this.submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.isValid();

                    int response = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to add $" + controller.getValuestring() + " to your account?",
                            "Confirm Credit", JOptionPane.YES_NO_OPTION);

                    if (response == JOptionPane.YES_OPTION) {
                        try {

                            UserController.addCredit(controller.getFloat());
                            Navigator.goToPrev();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        return;
                    }

                } catch (ValidationException ex) {
                    label.setForeground(Color.RED);
                    label.setText(ex.getMessage());
                }
            }

        });
    }

    public String getFieldValue() {
        return this.field.getText();
    }

}
