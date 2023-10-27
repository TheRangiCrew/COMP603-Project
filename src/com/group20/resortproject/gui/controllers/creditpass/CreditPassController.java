package com.group20.resortproject.gui.controllers.creditpass;

import com.group20.resortproject.Controller;
import com.group20.resortproject.View;
import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.Page;

public class CreditPassController implements Controller {

    public void addCredit() {
        Navigator.goTo(Page.CREDIT);
    }

    public void addPass() {
        Navigator.goTo(Page.LIFTPASS);
    }

    @Override
    public void addView(View view) {
    }

}
