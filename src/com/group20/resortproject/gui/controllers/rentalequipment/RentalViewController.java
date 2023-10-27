package com.group20.resortproject.gui.controllers.rentalequipment;

import com.group20.resortproject.Controller;
import com.group20.resortproject.Model;
import com.group20.resortproject.View;
import com.group20.resortproject.equipment.RentalEquipmentController;
import com.group20.resortproject.equipment.RentalItem;
import com.group20.resortproject.user.UserController;

public class RentalViewController implements Controller {

    public RentalViewController() {
        RentalEquipmentController.initRentalEquipment();
    }

    @Override
    public void addModel(Model model) {
    }

    @Override
    public void addView(View view) {
    }

    public void confirm(RentalItem item) throws Exception {
        UserController.getLoggedIn().chargeAccount(item.getEquipmentPrice());
        RentalEquipmentController.insertEquipment(item);
    }

}
