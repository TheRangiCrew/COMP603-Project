package com.group20.resortproject.views;

import com.group20.resortproject.controllers.Controller;
import java.util.Observer;

/**
 * The View component is used for all the UI logic of the application. All the
 * final components that the user will interact with
 */
public interface View extends Observer {
    public void addController(Controller controller);
}
