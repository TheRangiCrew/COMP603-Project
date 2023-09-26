package com.group20.resortproject;

import javax.swing.JFrame;

import com.formdev.flatlaf.FlatLightLaf;

public class Main extends javax.swing.JFrame {

    public static void main(String[] args) {
        FlatLightLaf.setup();

        MainFrame.initialise();
        MainFrame.getFrame().setSize(MainFrame.size);
        Navigator.goTo(Page.WELCOME);
        MainFrame.getFrame().setVisible(true);
        System.out.println("Starting");
    }

}
