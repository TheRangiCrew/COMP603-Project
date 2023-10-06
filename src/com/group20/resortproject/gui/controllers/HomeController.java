package com.group20.resortproject.gui.controllers;

import com.group20.resortproject.Controller;
import com.group20.resortproject.Model;
import com.group20.resortproject.View;
import com.group20.resortproject.gui.views.MainMenuView;

public class HomeController implements Controller {

    Model model;
    MainMenuView view;

    public HomeController() {

    }

    @Override
    public void addModel(Model model) {

    }

    @Override
    public void addView(View view) {
        this.view = (MainMenuView) view;
    }
}