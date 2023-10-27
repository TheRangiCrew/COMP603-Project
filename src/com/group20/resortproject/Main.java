package com.group20.resortproject;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.formdev.flatlaf.FlatLightLaf;
import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.Page;
import com.group20.resortproject.utility.DBManager;

public class Main {

    // The main JFrame
    private static JFrame frame;
    // The size that the application should launch at
    public static Dimension size = new Dimension(800, 800);

    public static void main(String[] args) {
        // Setting up the theme because this theme is so cool and all the others are so
        // bad because they all look like they're from the 1940s even though GUI
        // software wasn't available until...who cares. Java Swing's default look and
        // feel often gets roasted for its style that's stuck in a time warp, but hey,
        // nostalgia's a thing, and some folks might cherish that retro charm; however,
        // let's talk about FlatLaf – it's like the James Bond of Swing look and feels,
        // with a sleek and suave design that's smoother than shaken, not stirred
        // martinis, and it's won over more hearts than Bond's charm at a casino. With
        // its flat, clean aesthetics, it's like the minimalist designer of the Swing
        // world, making your app look so good it's practically ready for its own
        // fashion magazine cover. But remember, in the world of UI, taste is
        // subjective, and whether you go for the vintage vibes or modern flair, it's
        // all about making your app feel at home in its own skin, shaken or stirred –
        // your call!
        FlatLightLaf.setup();

        DBManager.establishConnection();

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenWidth = screenSize.width;
        double frameWidth = screenWidth * 0.7;
        int screenHeight = screenSize.height;
        double frameHeight = screenHeight * 0.7;
        size = new Dimension((int) frameWidth, (int) frameHeight);

        // Create the main JFrame of the program
        frame = new JFrame("Resort Kiosk");
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // Set the frame size
        frame.setSize(size);
        frame.setPreferredSize(size);
        // Add the main panel
        frame.add(MainPanel.getInstance());
        frame.pack();

        // Navigate to the welcome page and open the frame
        Navigator.goTo(Page.WELCOME);
        frame.setVisible(true);
    }

}
