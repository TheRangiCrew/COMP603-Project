package com.group20.resortproject;

import com.group20.resortproject.controllers.*;
import com.group20.resortproject.models.*;
import com.group20.resortproject.views.*;

public enum Page {

    WELCOME("Welcome", new WelcomeView(), new WelcomeController()),
    LOGIN("Login", new LoginModel(), new LoginView(), new LoginController());

    private String name;
    private Model model;
    private ViewPanel viewPanel;
    private Controller controller;

    private Page(String name, ViewPanel viewPanel, Controller controller) {
        this.name = name;
        this.model = null;
        this.viewPanel = viewPanel;
        this.controller = controller;
        this.controller.addView(this.viewPanel);
        this.viewPanel.addController(this.controller);

        MainFrame.getContentPanel().add(this.viewPanel, name);
        System.out.println(name + " initialised");
    }

    private Page(String name, Model model, ViewPanel viewPanel, Controller controller) {
        this.name = name;
        this.model = model;
        this.viewPanel = viewPanel;
        this.model.addObserver(this.viewPanel);

        this.controller = controller;
        this.controller.addModel(this.model);
        this.controller.addView(this.viewPanel);
        this.viewPanel.addController(this.controller);

        MainFrame.getContentPanel().add(this.viewPanel, name);
        System.out.println(name + " initialised");
    }

    public Model getModel() {
        return this.model;
    }

    public ViewPanel getView() {
        return this.viewPanel;
    }

    public Controller getController() {
        return this.controller;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
