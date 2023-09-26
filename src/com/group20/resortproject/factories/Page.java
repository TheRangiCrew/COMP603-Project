// package com.group20.resortproject.factories;

// import com.group20.resortproject.MainFrame;
// import com.group20.resortproject.controllers.Controller;
// import com.group20.resortproject.models.Model;
// import com.group20.resortproject.views.ViewPanel;

// public class Page {

// private String name;
// private Model model;
// private ViewPanel viewPanel;
// private Controller controller;

// public Page(String name, Model model, ViewPanel viewPanel, Controller
// controller) {
// this.model = model;
// this.viewPanel = viewPanel;
// this.model.addObserver(this.viewPanel);

// this.controller = controller;
// this.controller.addModel(this.model);
// this.controller.addView(this.viewPanel);
// this.viewPanel.addController(this.controller);

// MainFrame.getFrame().add(this.viewPanel, name);
// }

// public Model getModel() {
// return this.model;
// }

// public ViewPanel getView() {
// return this.viewPanel;
// }

// public Controller getController() {
// return this.controller;
// }
// }
