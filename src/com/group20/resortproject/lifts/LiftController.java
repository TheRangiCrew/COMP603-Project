package com.group20.resortproject.lifts;

import java.util.ArrayList;

public class LiftController {

    /**
     * 
     * @return the lifts in the resort
     */
    public static ArrayList<Lift> getLifts() {
        return LiftModel.getLifts();
    }
}
