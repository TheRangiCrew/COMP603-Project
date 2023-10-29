package com.group20.resortproject.gui.views.creditpass;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.group20.resortproject.Controller;
import com.group20.resortproject.gui.components.Heading;
import com.group20.resortproject.gui.controllers.creditpass.CreditPassController;
import com.group20.resortproject.gui.views.ViewPanel;
import com.group20.resortproject.user.UserController;

public class CreditPassView extends ViewPanel {

    private JButton creditButton;
    private JButton passButton;

    public CreditPassView() {
        /**
         * Setup
         */
        this.setLayout(new GridLayout(1, 2));

        /**
         * Create Components
         */
        /** The left credit panel */
        GridBagConstraints constraints = new GridBagConstraints();

        JPanel userPanel = new JPanel(new GridBagLayout());
        this.creditButton = new JButton("Add Credit");
        this.creditButton.setFont(creditButton.getFont().deriveFont(18f));

        /** The right lift pass panel */
        JPanel passPanel = new JPanel(new GridBagLayout());
        this.passButton = new JButton("Add Lift Pass");
        this.passButton.setFont(this.passButton.getFont().deriveFont(18f));

        /**
         * Add Components
         */
        /** Group all the credit panel components */
        userPanel.add(Box.createVerticalGlue());
        constraints.insets = new Insets(5, 0, 5, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        userPanel.add(new Heading(Heading.H4,
                "Credit: $" + new DecimalFormat("0.00").format(UserController.getLoggedIn().getCredit())), constraints);
        constraints.gridy++;
        userPanel.add(creditButton, constraints);
        userPanel.add(Box.createVerticalGlue());

        this.add(userPanel);

        /** Group all the lift pass panel components */
        passPanel.add(Box.createVerticalGlue());
        constraints.gridx = 0;
        constraints.gridy = 0;

        // Only render this if the user has a valid lift pass
        if (UserController.getLoggedIn().hasValidPass()) {
            constraints.insets = new Insets(20, 0, 20, 0);
            passPanel.add(new Heading(Heading.H4, "You have a current, valid pass! 🎉"), constraints);
            constraints.gridy++;
            passPanel.add(new Heading(Heading.H5, UserController.getLoggedIn().getValidLiftPass().toString()),
                    constraints);
        } else {
            passPanel.add(new Heading(Heading.H5, "You do not have any valid passes at the moment..."), constraints);
            constraints.gridy++;
            passPanel.add(passButton, constraints);

        }
        passPanel.add(Box.createVerticalGlue());

        this.add(passPanel);
    }

    public void addController(Controller c) {
        CreditPassController controller = (CreditPassController) c;

        this.creditButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addCredit();
            }

        });

        this.passButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addPass();
            }

        });
    }

}
