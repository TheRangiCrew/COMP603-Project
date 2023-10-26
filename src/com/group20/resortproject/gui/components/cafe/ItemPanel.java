package com.group20.resortproject.gui.components.cafe;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.group20.resortproject.cafe.Order;
import com.group20.resortproject.cafe.OrderItem;

public class ItemPanel extends JPanel {

    private OrderItem item;
    private Order order;

    public ItemPanel(OrderItem item, Order order) {
        this.item = item;
        this.order = order;

        DecimalFormat priceFormatter = new DecimalFormat("$0.00");

        this.setBackground(Color.WHITE);

        this.setLayout(new GridLayout());

        this.add(new JLabel(item.getItem().getName()));

        this.add(new JLabel(String.valueOf(item.getQuantity())));

        this.add(new JLabel(priceFormatter.format(item.getTotalCost())));

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                order.removeItem(item, 1);
            }

        });

        this.add(removeButton);

    }

}
