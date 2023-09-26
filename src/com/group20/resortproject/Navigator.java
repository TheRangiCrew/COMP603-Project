package com.group20.resortproject;

import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;

public class Navigator {

    private static Navigator instance = new Navigator();
    private static ArrayList<Page> previous;
    private static Page current;

    private Navigator() {
        Navigator.previous = new ArrayList<>();
        Navigator.current = null;
    }

    public static Navigator getInstance() {
        return instance;
    }

    private static boolean setCardLayout(Page page) {
        LayoutManager layout = MainFrame.getContentPanel().getLayout();

        if (!(layout instanceof CardLayout)) {
            return false;
        }

        CardLayout cl = (CardLayout) layout;
        System.out.println("Going to " + page.getName());
        cl.show(MainFrame.getContentPanel(), page.getName());

        return true;
    }

    public static boolean goToPrev() {
        int index = previous.size() - 1;
        Page prev = previous.get(index);

        if (!(setCardLayout(prev))) {
            return false;
        }

        current = prev;
        previous.remove(index);
        MainFrame.getTopBar().update();
        return true;
    }

    public static boolean goTo(Page page) {

        if (!(setCardLayout(page))) {
            return false;
        }

        if (current != null) {
            previous.add(current);
        }
        current = page;
        MainFrame.getTopBar().update();
        return true;
    }

    public static boolean hasPrevious() {
        return previous.size() > 0;
    }

    public static Page getCurrent() {
        return current;
    }
}
