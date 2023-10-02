package com.group20.resortproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;

import com.group20.resortproject.gui.components.TopBar;

/**
 * The Main panel that all pages are displayed in. Contains a content pain and
 * an informative information bar at the top of the panel
 * 
 * @see JPanel
 * @see TopBar
 */
public class MainPanel extends JPanel {

    // The JPanel instance. Only one
    private static MainPanel instance;
    // The TopBar top bar
    private static TopBar topBar;
    // The panel where all pages are displayed
    private static JPanel contentPanel;

    /**
     * Initialise a single instance of a JFrame with an embedded JPanel. Also
     * features a really cool and handy top bar of application information like the
     * current page and a back button 👌
     * 
     * @see TopBar
     */
    private MainPanel() {

        setLayout(new BorderLayout());

        topBar = new TopBar();

        contentPanel = new JPanel(new CardLayout());

        add(topBar, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    /**
     * @return the MainPanel instance
     */
    public static JPanel getInstance() {
        if (instance == null) {
            instance = new MainPanel();
        }
        return instance;
    }

    /**
     * @return the content panel
     */
    public static JPanel getContentPanel() {
        return contentPanel;
    }

    /**
     * 
     * @return the TopBar instance
     * @see TopBar
     */
    public static TopBar getTopBar() {
        return topBar;
    }

}
