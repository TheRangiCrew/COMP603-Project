package com.group20.resortproject.controllers;

import java.util.EventListener;

import com.group20.resortproject.models.Model;
import com.group20.resortproject.views.View;

/**
 * Controllers act as an interface between Model and View components to process
 * all the business logic and incoming requests, manipulate data using the Model
 * component and interact with the Views to render the final output.
 */
public abstract class Controller implements EventListener {

    Model model;
    View view;

    public Controller() {
    }

    public void addModel(Model model) {
        this.model = model;
    }

    public void addView(View view) {
        this.view = view;
    }

    public abstract void initModel();
}
