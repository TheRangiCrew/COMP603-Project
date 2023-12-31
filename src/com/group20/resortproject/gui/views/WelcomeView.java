package com.group20.resortproject.gui.views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import com.group20.resortproject.Controller;
import com.group20.resortproject.Main;
import com.group20.resortproject.gui.components.Heading;
import com.group20.resortproject.gui.controllers.WelcomeController;

/**
 * The Welcome Page when the application first launches
 */
public class WelcomeView extends ViewPanel {

    JButton loginButton;
    JButton registerButton;

    public WelcomeView() {
        /**
         * Setup
         */
        this.setSize(Main.size);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        /**
         * Create Components
         */
        Heading welcomeHeading = new Heading(Heading.H1, "Welcome to the mountain!");
        welcomeHeading.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton = new JButton("Login");
        loginButton.setFont(loginButton.getFont().deriveFont(32f));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        registerButton = new JButton("Register");
        registerButton.setFont(registerButton.getFont().deriveFont(32f));
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        /**
         * Add Components
         */
        this.add(Box.createVerticalGlue());
        this.add(welcomeHeading);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(loginButton);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(registerButton);
        this.add(Box.createVerticalGlue());
    }

    @Override
    public void addController(Controller c) {
        WelcomeController controller = (WelcomeController) c;
        System.out.println("Added");
        this.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the controller method when the button is clicked
                controller.loginClicked();
            }
        });
        this.registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the controller method when the button is clicked
                controller.registerClicked();
            }
        });
    }

}
