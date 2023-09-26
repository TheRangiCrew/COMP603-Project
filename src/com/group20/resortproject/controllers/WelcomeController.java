package com.group20.resortproject.controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.group20.resortproject.Navigator;
import com.group20.resortproject.Page;

public class WelcomeController extends Controller implements MouseListener {

    @Override
    public void initModel() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Navigator.goTo(Page.LOGIN);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
