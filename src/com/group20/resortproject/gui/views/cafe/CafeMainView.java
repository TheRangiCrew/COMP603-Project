package com.group20.resortproject.gui.views.cafe;

import com.group20.resortproject.cafe.CafeCategories;
import com.group20.resortproject.cafe.CafeController;
import com.group20.resortproject.cafe.Item;
import com.group20.resortproject.gui.components.Heading;
import com.group20.resortproject.gui.views.ViewPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CafeMainView extends ViewPanel {

    private JPanel menuPanel;

    public CafeMainView() {
        /**
         * Setup
         */
        this.setLayout(new GridLayout(1, 2));

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;

        Insets categoryInset = new Insets(10, 0, 5, 0);
        Insets itemInset = new Insets(2, 0, 2, 0);

        CafeController.initCafe();

        /**
         * Create Components
         */
        this.menuPanel = new JPanel(new GridBagLayout());
        this.menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        /**
         * Group Components
         */
        /** Menu Items */
        HashMap<CafeCategories, ArrayList<Item>> items = CafeController.getItems();
        ArrayList<CafeCategories> categories = new ArrayList<>(items.keySet());

        DecimalFormat priceFormatter = new DecimalFormat("0.00");

        for (CafeCategories cat : categories) {
            ArrayList<Item> itemList = items.get(cat);

            constraints.gridx = 0;
            constraints.gridy++;
            constraints.insets = categoryInset;

            this.menuPanel.add(new Heading(Heading.H6, cat.getName()), constraints);
            for (Item item : itemList) {
                constraints.insets = itemInset;

                constraints.gridx = 0;
                constraints.gridy++;
                constraints.gridwidth = 1;
                constraints.anchor = GridBagConstraints.WEST;
                this.menuPanel.add(new JLabel("<html><b>" + item.getName() + "</b></html>"), constraints);

                constraints.gridx++;
                constraints.anchor = GridBagConstraints.EAST;
                this.menuPanel.add(new JLabel("$" + priceFormatter.format(item.getPrice())), constraints);

                constraints.gridx = 0;
                constraints.gridy++;
                constraints.gridwidth = 2;
                constraints.anchor = GridBagConstraints.WEST;
                this.menuPanel.add(new JLabel(item.getDescription()), constraints);
            }
        }

        this.add(new JScrollPane(this.menuPanel));

        /** */
        this.add(new JPanel());
    }

}
