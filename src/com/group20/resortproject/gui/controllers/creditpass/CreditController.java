package com.group20.resortproject.gui.controllers.creditpass;

import java.text.DecimalFormat;

import com.group20.resortproject.Controller;
import com.group20.resortproject.Model;
import com.group20.resortproject.View;
import com.group20.resortproject.gui.views.creditpass.CreditView;
import com.group20.resortproject.utility.ValidationException;

public class CreditController implements Controller {

    private CreditView view;
    private float valueFloat;
    private String valueString;

    public CreditController() {
    }

    public void isValid() throws ValidationException {
        try {
            System.out.println(view.getFieldValue());
            this.valueFloat = Float.parseFloat(view.getFieldValue());
            System.out.println(this.valueFloat);
            this.valueString = new DecimalFormat("0.00").format(this.valueFloat);
            System.out.println(this.valueString);

        } catch (IllegalArgumentException e) {
            throw new ValidationException("Not a number. Please enter a number greater than 0");
        }

        if (this.valueFloat > 0) {
            return;
        } else {
            throw new ValidationException("Input cannot be less than 0. Please enter a number greater than 0");
        }
    }

    public float getFloat() {
        return this.valueFloat;
    }

    public String getValuestring() {
        return this.valueString;
    }

    @Override
    public void addModel(Model model) {

    }

    @Override
    public void addView(View view) {
        this.view = (CreditView) view;
    }

}
