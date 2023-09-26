package com.group20.resortproject.controllers;

import com.group20.resortproject.models.Model;
import com.group20.resortproject.views.View;

public class LoginController extends Controller {

    Model model;
    View view;

    private final String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public LoginController() {
    }

    @Override
    public void initModel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initModel'");
    }

}
