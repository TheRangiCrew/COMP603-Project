package com.group20.resortproject.controllers;

import java.util.EventListener;

import com.group20.resortproject.models.Model;
import com.group20.resortproject.views.View;

/**
 * Controllers act as an interface between Model and View components to process
 * all the business logic and incoming requests, manipulate data using the Model
 * component and interact with the Views to render the final output.
 */
public interface Controller extends EventListener {

    public void addModel(Model model);

    public void addView(View view);
}
