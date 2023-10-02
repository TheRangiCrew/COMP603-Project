package com.group20.resortproject.controllers;

import com.group20.resortproject.Navigator;
import com.group20.resortproject.Page;
import com.group20.resortproject.models.Model;
import com.group20.resortproject.views.View;

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
