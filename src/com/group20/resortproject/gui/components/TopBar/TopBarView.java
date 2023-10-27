package com.group20.resortproject.gui.components.TopBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.Page;
import com.group20.resortproject.user.UserController;

public class TopBarView extends JPanel {

    private JButton backButton;
    private JPanel centerPanel;
    private TopBarButton[] navButtons;
    private JButton logoutButton;

    public TopBarView() {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20, 10, 20, 10));

        /**
         * The BACK BUTTON
         */
        this.backButton = new JButton("Back");
        this.backButton.setEnabled(false);
        this.backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Navigator.goToPrev();
            }

        });
        this.add(this.backButton, BorderLayout.WEST);

        /**
         * Navigation Bar
         */
        this.centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        // This adds spacing between each field (in pixels)
        constraints.insets = new Insets(0, 10, 0, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;

        this.add(Box.createVerticalGlue());

        // The different buttons for the navigation bar
        this.navButtons = new TopBarButton[] {
                new TopBarButton("Home", Page.HOME),
                new TopBarButton("Credit & Lift Passes", Page.CREDITPASS),
                new TopBarButton("Mountain Café", Page.CAFE),
                new TopBarButton("Rental Equipment", Page.RENTALEQUIPMENT),
        };

        Color activeColour = new Color(54, 133, 245);
        Color defaultColour = new Color(30, 38, 48);

        // Apply styles and action listeners to all buttons
        for (TopBarButton button : navButtons) {
            button.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, defaultColour));
            button.setBackground(new Color(0, 0, 0, 0));
            button.setFont(button.getFont().deriveFont(18.0f));
            constraints.gridx++;
            this.centerPanel.add(button, constraints);
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    button.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, activeColour));
                }

            });
        }

        this.add(this.centerPanel, BorderLayout.CENTER);

        /**
         * The LOGOUT BUTTON
         */
        this.logoutButton = new JButton("Logout");
        this.logoutButton.setEnabled(false);
        this.logoutButton.addActionListener(new ActionListener() {

            // When the logout button is pressed, log the user out and navigate to the
            // welcome page
            @Override
            public void actionPerformed(ActionEvent e) {
                UserController.logout();
                Navigator.goTo(Page.WELCOME);
                Navigator.resetPrevious();
            }

        });
        this.add(this.logoutButton, BorderLayout.EAST);
    }

    /**
     * Update the components to reflect the latest state of several program
     * variables
     */
    public void update() {
        this.backButton.setEnabled(Navigator.hasPrevious());
        this.centerPanel.setVisible(UserController.isLoggedIn());
        this.logoutButton.setEnabled(UserController.isLoggedIn());
    }

}
