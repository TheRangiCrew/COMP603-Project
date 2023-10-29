package com.group20.resortproject.gui.controllers.cafe;

import java.util.Observable;
import java.util.Observer;

import com.group20.resortproject.Controller;
import com.group20.resortproject.View;
import com.group20.resortproject.cafe.Item;
import com.group20.resortproject.cafe.Order;
import com.group20.resortproject.gui.views.cafe.CafeMainView;

public class CafeMainController implements Controller, Observer {

    public Order order;

    private CafeMainView view;

    public CafeMainController() {
        this.order = new Order();
        this.order.addObserver(this);
    }

    public void addItem(Item item) {
        this.order.add(item);
    }

    public void submit() throws Exception {
        try {
            this.order.submit();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void addView(View view) {
        this.view = (CafeMainView) view;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Order) {
            this.view.update();
        }
    }

}
