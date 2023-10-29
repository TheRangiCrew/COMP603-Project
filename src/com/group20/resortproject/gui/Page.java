package com.group20.resortproject.gui;

import java.lang.reflect.InvocationTargetException;

import com.group20.resortproject.Controller;
import com.group20.resortproject.MainPanel;
import com.group20.resortproject.gui.controllers.*;
import com.group20.resortproject.gui.controllers.cafe.*;
import com.group20.resortproject.gui.controllers.creditpass.*;
import com.group20.resortproject.gui.controllers.rentalequipment.*;
import com.group20.resortproject.gui.views.*;
import com.group20.resortproject.gui.views.cafe.*;
import com.group20.resortproject.gui.views.creditpass.*;

/**
 * ALL the pages that can be navigated to in the program. This is very much an
 * experimental thing and will likely change in the future. Each page is an enum
 * for easy referencing and control over MVC classes
 */
public enum Page {

    /**
     * The Pages with their own name and MVC classes
     */
    WELCOME("Welcome", WelcomeView.class, WelcomeController.class),
    LOGIN("Login", LoginView.class, LoginController.class),
    REGISTER("Register", RegisterView.class, RegisterController.class),
    HOME("Home", MainMenuView.class, HomeController.class),
    /** Credit and Lift Pass pages */
    CREDITPASS("Credit & Lift Passes", CreditPassView.class, CreditPassController.class),
    LIFTPASS("Add Lift Pass", LiftPassView.class, LiftPassController.class),
    CREDIT("Add Credit", CreditView.class, CreditController.class),
    /** Mountain Cafe */
    CAFE("Mountain Cafe", CafeMainView.class, CafeMainController.class),
    /** RentalEquipment */
    RENTALEQUIPMENT("Rental Equipment", RentalEquipmentView.class, RentalViewController.class);

    // User friendly name of the page
    private String name;
    // MVC view of the page
    private ViewPanel view;
    // MVC controller of the page
    private Controller controller;
    // Classes
    private Class<? extends ViewPanel> viewClass;
    private Class<? extends Controller> controllerClass;

    /**
     * Creates an instance of a page without a model, for pages that only have
     * content and interactive elements with no data (i.e. the welcome page)
     * 
     * @param name        user friendly name of the page
     * @param view
     * @param controller
     * @param restriction
     */
    private Page(String name, Class<? extends ViewPanel> viewClass,
            Class<? extends Controller> controllerClass) {
        this.name = name;
        this.viewClass = viewClass;
        this.controllerClass = controllerClass;
    }

    public void initialise() {
        if (viewClass != null && controllerClass != null) {
            try {
                // Instantiate the view and controller
                this.view = viewClass.getDeclaredConstructor().newInstance();
                this.controller = controllerClass.getDeclaredConstructor().newInstance();

                this.controller.addView(view);
                this.view.addController(controller);

                // Add the page to the content panel CardLayout in MainPanel
                MainPanel.getContentPanel().add(view, name);
                System.out.println(name + " initialised");
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                // Handle exception
                System.out.println("Oops.... navigation cancelled");
                e.printStackTrace();
            }
        }
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
     * @return the name of the page
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
