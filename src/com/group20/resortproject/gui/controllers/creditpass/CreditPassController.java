package com.group20.resortproject.gui.controllers.creditpass;

import com.group20.resortproject.Controller;
import com.group20.resortproject.Model;
import com.group20.resortproject.View;
import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.Page;
import com.group20.resortproject.gui.views.creditpass.CreditPassView;

public class CreditPassController implements Controller {

    private CreditPassView view;

    public void addCredit() {
        Navigator.goTo(Page.CREDIT);
    }

    public void addPass() {
        Navigator.goTo(Page.LIFTPASS);
    }

    @Override
    public void addModel(Model model) {

    }

    @Override
    public void addView(View view) {
        this.view = (CreditPassView) view;
    }

}
