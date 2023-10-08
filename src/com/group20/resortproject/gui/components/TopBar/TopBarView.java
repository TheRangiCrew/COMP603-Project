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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
         * That thing in the middle
         */
        GridBagConstraints constraints = new GridBagConstraints();
        // This adds spacing between each field (in pixels)
        constraints.insets = new Insets(0, 10, 0, 10);

        this.centerPanel = new JPanel(new GridBagLayout());
         this.add(Box.createVerticalGlue());
        constraints.gridx = 0;
        constraints.gridy = 0;


        this.navButtons = new TopBarButton[]{
            new TopBarButton("Home", Page.HOME),
            new TopBarButton("Credit & Lift Passes", Page.HOME),
            new TopBarButton("Mountain Café", Page.HOME),
            new TopBarButton("Rental Equipment", Page.HOME),
        };

        Color activeColour = new Color(54, 133, 245);
        Color defaultColour = new Color(30, 38, 48);

        // Apply all button styles
        for (TopBarButton button: navButtons) {
            button.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, defaultColour));
            button.setBackground(new Color(0,0,0,0));
            button.setFont(button.getFont().deriveFont(18.0f));
            constraints.gridx++;
            this.centerPanel.add(button, constraints);
            button.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    button.navigate();
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
        this.centerPanel.setVisible(UserController.isLoggedIn());
        this.logoutButton.setEnabled(UserController.isLoggedIn());
    }

}
