package com.group20.resortproject.gui.controllers;

import java.util.ArrayList;

import com.group20.resortproject.Controller;
import com.group20.resortproject.Model;
import com.group20.resortproject.View;
import com.group20.resortproject.gui.views.MainMenuView;
import com.group20.resortproject.lifts.Lift;
import com.group20.resortproject.lifts.LiftModel;

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