package com.group20.resortproject.gui.controllers.creditpass;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.group20.resortproject.Controller;
import com.group20.resortproject.View;
import com.group20.resortproject.gui.views.creditpass.LiftPassView;
import com.group20.resortproject.lifts.LiftPass;
import com.group20.resortproject.lifts.LiftPassModel;
import com.group20.resortproject.user.UserController;

public class LiftPassController implements Controller {

    LiftPassView view;

    public LiftPassController() {
    }

    public boolean addLiftPass() {
        int selected = this.view.getSelectedIndex();

        LocalDateTime today = LocalDate.now().atStartOfDay();
        LocalDateTime endOfToday = LocalDate.now().atTime(23, 59);
        LiftPass pass = null;

        switch (selected) {
            // 1/2
            case 0:
            case 1:
                // Add a new lift pass that lasts from the start to the end of the current day
                pass = new LiftPass(today, endOfToday);
                break;
            // Five day pass
            case 2:
                // Add a new lift pass that lasts from the start of today to the end of 5 days
                // from now
                pass = new LiftPass(today, endOfToday.plusDays(5));
                break;
            // Seven day pass
            case 3:
                // Add a new lift pass that lasts from the start of today to the end of 7 days
                // from now
                pass = new LiftPass(today, endOfToday.plusDays(7));
                break;
            // Season pass
            case 4:
                // Add a new lift pass that last from the start of today to the end of the day
                // of the 8th of October (season end)
                pass = new LiftPass(today, LocalDate.parse("2024-04-10").atTime(23, 59));
                break;
            default:
                return false;
        }

        try {
            LiftPassModel.addLiftPass(pass);
        } catch (SQLException e) {
            return false;
        }
        UserController.updateLiftPasses();
        return true;
    }

    @Override
    public void addView(View view) {
        this.view = (LiftPassView) view;
    }

}
