package com.group20.resortproject.gui.components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.user.UserController;

public class TopBar extends JPanel {

    private JButton backButton;
    private JLabel label;
    private JButton logoutButton;

    public TopBar() {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20, 10, 20, 10));

        this.backButton = new JButton("Back");
        this.backButton.setEnabled(false);
        this.backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Navigator.goToPrev();
            }

            

        });
        this.add(this.backButton, BorderLayout.WEST);

        this.label = new JLabel("");
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
        this.label.setVerticalAlignment(SwingConstants.CENTER);
        this.add(this.label, BorderLayout.CENTER);

        this.logoutButton = new JButton("Logout");
        this.logoutButton.setEnabled(false);
        this.logoutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UserController.logout();
                Navigator.goToHome();
            }

        });
        this.add(this.logoutButton, BorderLayout.EAST);
    }

    public void update() {
        this.backButton.setEnabled(Navigator.hasPrevious());
        this.label.setText(Navigator.getCurrent().getName());
        this.logoutButton.setEnabled(UserController.isLoggedIn());
    }

}
