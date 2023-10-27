package com.group20.resortproject.gui.views;

import java.util.Observable;
import javax.swing.JPanel;

import com.group20.resortproject.Controller;
import com.group20.resortproject.View;

/**
 * A generic class that combines an observable View and the JPanel class to
 * reduce complexity and improve consistency for all views in an MVC designed
 * program
 */
public class ViewPanel extends JPanel implements View {

    @Override
    public void update(Observable o, Object arg) {
    }

    @Override
    public void addController(Controller controller) {
    }

}
