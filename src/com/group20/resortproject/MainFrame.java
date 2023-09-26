package com.group20.resortproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.group20.resortproject.components.TopBar;

public class MainFrame extends JPanel {

    private static JFrame frame;
    private static JPanel mainPanel;
    private static TopBar topBar;
    private static JPanel contentPanel;
    private static Page currentPage;
    public static Dimension size = new Dimension(800, 800);

    public static void initialise() {
        frame = new JFrame("My GUI");
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());

        topBar = new TopBar();

        contentPanel = new JPanel(new CardLayout());

        mainPanel.add(topBar, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.pack();
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static JPanel getMainPanel() {
        return mainPanel;
    }

    public static JPanel getContentPanel() {
        return contentPanel;
    }

    public static TopBar getTopBar() {
        return topBar;
    }

}
