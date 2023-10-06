package com.group20.resortproject.gui;

import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

import com.group20.resortproject.MainPanel;

/**
 * Handles the page navigation of the application. Essentially just switches the
 * CardLayout of the content panel in MainFrame
 * 
 * @see MainPanel
 * @see CardLayout
 */
public class Navigator {

    // Instance of the Navigator. Only one
    private static Navigator instance = new Navigator();
    // The previous pages that were accessed by the user
    private static ArrayList<Page> previous;
    /**
     * The current page
     * 
     * @see Page
     */
    private static Page current;

    /**
     * The constructor for the navigator. Should only be accessed from inside the
     * Navigator class, as per the singleton pattern
     */
    private Navigator() {
        Navigator.previous = new ArrayList<>();
        Navigator.current = null;
    }

    /**
     * @return the instance of Navigator
     */
    public static Navigator getInstance() {
        return instance;
    }

    /**
     * A helper method to set the card layout of the MainPanel
     * 
     * @param page the page to navigate to
     * @return true if successful, otherwise false
     * 
     * @see Page
     */
    private static boolean setCardLayout(Page page) {

        // Get the layout of the content panel. This is the only way to access the
        // CardLayout instance the panel uses to switch pages
        LayoutManager layout = MainPanel.getContentPanel().getLayout();

        // Make sure its the correct LayoutManager
        if (!(layout instanceof CardLayout)) {
            return false;
        }

        // Type cast the layout to CardLayout
        CardLayout cl = (CardLayout) layout;
        page.initialise();
        System.out.println("Going to " + page.getName());
        // Set the panel to the requested page
        cl.show(MainPanel.getContentPanel(), page.getName());

        return true;
    }

    /**
     * Go back one page
     * 
     * @return {@code true} if successful, else {@code false}
     */
    public static boolean goToPrev() {
        int index = previous.size() - 1;
        Page prev = previous.get(index);

        if (!(setCardLayout(prev))) {
            return false;
        }

        current = prev;
        previous.remove(index);
        MainPanel.getTopBar().update();
        return true;
    }

    public static void goToHome() {
        goTo(Page.WELCOME);
        resetPrevious();
    }

    /**
     * Go to a specified page
     * 
     * @param page Page enum to navigate to
     * @return {@code true} if successful, else {@code false}
     */
    public static boolean goTo(Page page) {

        if (!(setCardLayout(page))) {
            return false;
        }

        if (current != null) {
            previous.add(current);
        }
        current = page;
        MainPanel.getTopBar().update();
        return true;
    }

    /**
     * 
     * @return {@code true} if a previous page is available to navigate to, else
     *         {@code false}
     */
    public static boolean hasPrevious() {
        return previous.size() > 0;
    }

    /**
     * 
     * @return the current page the user is on
     */
    public static Page getCurrent() {
        return current;
    }

    public static void resetPrevious() {
        previous.clear();
        MainPanel.getTopBar().update();
    }
}
