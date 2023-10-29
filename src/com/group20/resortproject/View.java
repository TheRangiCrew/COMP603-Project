package com.group20.resortproject;

import java.util.Observer;

/**
 * The View component is used for all the UI logic of the application. All the
 * final components that the user will interact with
 */
public interface View extends Observer {
    /**
     * Add a controller to the view. Any interactions between the view and a
     * controller should happen here
     * 
     * @param controller the controller to add
     */
    public void addController(Controller controller);
}
