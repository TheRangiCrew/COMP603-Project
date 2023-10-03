package com.group20.resortproject.gui;

import com.group20.resortproject.Controller;
import com.group20.resortproject.MainPanel;
import com.group20.resortproject.Model;
import com.group20.resortproject.gui.controllers.*;
import com.group20.resortproject.gui.views.*;
import com.group20.resortproject.user.UserController;

/**
 * ALL the pages that can be navigated to in the program. This is very much an
 * experimental thing and will likely change in the future. Each page is an enum
 * for easy referencing and control over MVC classes
 */
public enum Page {

    /**
     * The Pages with their own name and MVC classes
     */
    WELCOME("Welcome", new WelcomeView(), new WelcomeController()),
    LOGIN("Login", new LoginView(), new LoginController()),
    REGISTER("Register", new RegisterView(), new RegisterController());
    
    // User friendly name of the page
    private String name;
    // MVC Model of the page
    private Model model;
    // MVC view of the page
    private ViewPanel view;
    // MVC controller of the page
    private Controller controller;
    // If a page requires a user to be loggedin or not
    private PageConstraints constraint;

    /**
     * Creates an instance of a page without a model, for pages that only have
     * content and interactive elements with no data (i.e. the welcome page)
     * 
     * @param name       user friendly name of the page
     * @param view
     * @param controller
     */
    private Page(String name, ViewPanel view, Controller controller) {
        this.name = name;
        this.model = null;
        this.view = view;
        this.controller = controller;
        this.constraint = PageConstraints.NONE;
        // Pass references between MVC instances so they can communicate
        this.controller.addView(this.view);
        this.view.addController(this.controller);

        // Add the page to the content panel CardLayout in MainPanel so it can be
        // navigated to with just it's name
        MainPanel.getContentPanel().add(this.view, name);
        System.out.println(name + " initialised");
    }

    /**
     * Creates an instance of a page without a model, for pages that only have
     * content and interactive elements with no data (i.e. the welcome page)
     * 
     * @param name       user friendly name of the page
     * @param view
     * @param controller
     * @param restriction
     */
    private Page(String name, ViewPanel view, Controller controller, PageConstraints restriction) {
        this.name = name;
        this.model = null;
        this.view = view;
        this.controller = controller;
        this.constraint = restriction;
        // Pass references between MVC instances so they can communicate
        this.controller.addView(this.view);
        this.view.addController(this.controller);

        // Add the page to the content panel CardLayout in MainPanel so it can be
        // navigated to with just it's name
        MainPanel.getContentPanel().add(this.view, name);
        System.out.println(name + " initialised");
    }

    /**
     * Creates an instance of a fully functional page with a model, view and
     * controller
     * 
     * @param name       user friendly name of the page
     * @param model
     * @param view
     * @param controller
     */
    private Page(String name, Model model, ViewPanel view, Controller controller) {
        this.name = name;
        this.model = model;
        this.view = view;
        this.controller = controller;
        this.constraint = PageConstraints.NONE;
        // Pass references between MVC instances so they can communicate
        this.model.addObserver(this.view);
        this.controller.addModel(this.model);
        this.controller.addView(this.view);
        this.view.addController(this.controller);

        // Add the page to the content panel CardLayout in MainPanel so it can be
        // navigated to with just it's name
        MainPanel.getContentPanel().add(this.view, name);
        System.out.println(name + " initialised");
    }

    /**
     * 
     * @return the Model of the page
     * @see Model
     */
    public Model getModel() {
        return this.model;
    }

    /**
     * 
     * @return the ViewPanel of the page
     * @see ViewPanel
     */
    public ViewPanel getView() {
        return this.view;
    }

    /**
     * 
     * @return the controller of the page
     * @see Controller
     */
    public Controller getController() {
        return this.controller;
    }

    /**
     * 
     * @return the name of the page
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return the constraint on the page
     */
    public PageConstraints getConstraint() {
        return this.constraint;
    }


    public boolean isAllowed() {
        switch (this.constraint) {
            case LOGGEDOUT:
             return !(UserController.isLoggedIn());
            case LOGGEDIN:
                return UserController.isLoggedIn();
            default: // NONE
                return true;
            
        }
    }

    /**
     * @return the name of the page
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
