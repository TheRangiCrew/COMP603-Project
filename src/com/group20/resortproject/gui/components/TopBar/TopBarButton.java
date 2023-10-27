package com.group20.resortproject.gui.components.TopBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.Page;

/**
 * Button for the TopBar
 * 
 * @see TopBarView
 */
public class TopBarButton extends JButton {

    // The page to navigate to when the button is clicked
    private Page page;

    /**
     * 
     * @param text the text to display
     * @param page the page to navigate to
     */
    public TopBarButton(String text, Page page) {
        this.setText(text);
        this.page = page;

        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                navigate();
            }

        });
    }

    // Navigate to the button's page
    public void navigate() {
        Navigator.goTo(this.page);
    }
}
