package com.group20.resortproject;

import java.util.EventListener;

/**
 * Controllers act as an interface between Model and View components to process
 * all the business logic and incoming requests, manipulate data using the Model
 * component and interact with the Views to render the final output.
 */
public interface Controller extends EventListener {

    /**
     * Add a view to the current controller for easy access to the View
     * 
     * @param view the view to add
     */
    public void addView(View view);
}
