package com.group20.resortproject.gui.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.group20.resortproject.Main;
import com.group20.resortproject.gui.components.Heading;
import com.group20.resortproject.lifts.Lift;
import com.group20.resortproject.lifts.LiftController;
import com.group20.resortproject.user.User;
import com.group20.resortproject.user.UserController;

public class MainMenuView extends ViewPanel {

    private JPanel leftPanel;
    private JPanel rightPanel;

    public MainMenuView() {

        /**
         * Setup
         */
        // Setup the main panel
        this.setSize(Main.size);
        this.setLayout(new GridLayout(1, 2));
        // Left panel Grid Bag constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 2, 5, 2);

        /**
         * Left Panel Components (User Details Overview)
         */
        this.leftPanel = new JPanel(new GridBagLayout());
        this.leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.leftPanel.add(Box.createVerticalGlue());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        this.leftPanel.add(new Heading(Heading.H5, "Account Overview"), constraints);
        constraints.gridheight = 1;
        constraints.gridy += 2;
        constraints.anchor = GridBagConstraints.WEST;
        this.leftPanel.add(new JLabel("Full name: " + UserController.getLoggedIn().getName()), constraints);
        constraints.gridy++;
        this.leftPanel.add(new JLabel("E-mail address: " + UserController.getLoggedIn().getEmail()), constraints);
        constraints.gridy++;
        this.leftPanel.add(new JLabel("Phone number: " + UserController.getLoggedIn().getPhone()), constraints);
        constraints.gridy++;
        this.leftPanel.add(new JLabel("Date of birth: " + UserController.getLoggedIn().getDob()), constraints);
        constraints.gridy++;
        this.leftPanel.add(new JLabel("Account credit: $" + UserController.getLoggedIn().getCredit()), constraints);
        constraints.gridy++;
        this.leftPanel.add(new JLabel("Lift Pass: " + (UserController.getLoggedIn().hasValidPass()
                ? UserController.getLoggedIn().getValidLiftPass().toString()
                : "No Valid Passes")), constraints);

        /**
         * Right Panel Components (Lift Information)
         */
        this.rightPanel = new JPanel();

        this.rightPanel = new JPanel(new GridBagLayout());
        this.rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.rightPanel.add(Box.createVerticalGlue());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        this.rightPanel.add(new Heading(Heading.H5, "Lift Report"), constraints);
        constraints.gridheight = 1;
        constraints.gridy += 2;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Open hours");
        model.addColumn("Status");

        for (Lift lift : LiftController.getLifts()) {
            model.addRow(
                    new Object[] { lift.getName(),
                            lift.getOpeningTime().toString() + " - " + lift.getClosingTime().toString(),
                            lift.getLiftStatus() });
        }

        JTable table = new JTable(model);
        table.setEnabled(false);
        table.setPreferredSize(new Dimension(350, (int) (Main.size.getHeight() * 0.6)));
        this.rightPanel.add(table, constraints);
        /**
         * Combine all components and panels
         */
        this.add(leftPanel);
        this.add(rightPanel);
    }

}
