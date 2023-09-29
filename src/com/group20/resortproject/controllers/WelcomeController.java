package com.group20.resortproject.controllers;

import com.group20.resortproject.Navigator;
import com.group20.resortproject.Page;

public class WelcomeController extends Controller {

    public void loginClicked() {
        Navigator.goTo(Page.LOGIN);
    }

    public void registerClicked() {
        Navigator.goTo(Page.REGISTER);
    }

    @Override
    public void initModel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initModel'");
    }


}
