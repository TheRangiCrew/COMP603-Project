package com.group20.resortproject.gui.controllers;

import com.group20.resortproject.Controller;
import com.group20.resortproject.Model;
import com.group20.resortproject.View;
import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.Page;

public class WelcomeController implements Controller {

    public void loginClicked() {
        Navigator.goTo(Page.LOGIN);
    }

    public void registerClicked() {
        Navigator.goTo(Page.REGISTER);
    }

    @Override
    public void addModel(Model model) {
        
    }

    @Override
    public void addView(View view) {
        
    }


}
