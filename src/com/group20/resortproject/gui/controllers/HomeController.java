package com.group20.resortproject.gui.controllers;

import com.group20.resortproject.Controller;
import com.group20.resortproject.View;
import com.group20.resortproject.gui.views.MainMenuView;

public class HomeController implements Controller {

    MainMenuView view;

    public HomeController() {

    }

    @Override
    public void addView(View view) {
        this.view = (MainMenuView) view;
    }
}