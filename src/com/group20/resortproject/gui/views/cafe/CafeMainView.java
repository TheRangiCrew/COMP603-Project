package com.group20.resortproject.gui.views.cafe;

import com.group20.resortproject.Controller;
import com.group20.resortproject.cafe.CafeCategories;
import com.group20.resortproject.cafe.CafeController;
import com.group20.resortproject.cafe.Item;
import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.components.Heading;
import com.group20.resortproject.gui.components.cafe.OrderPanel;
import com.group20.resortproject.gui.controllers.cafe.CafeMainController;
import com.group20.resortproject.gui.views.ViewPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class CafeMainView extends ViewPanel {

    private JPanel menuPanel;
    private JPanel rightPanel;
    private OrderPanel orderPanel;
    private JTabbedPane bottomPanel;

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
        /** Menu Items */
        this.menuPanel = new JPanel(new GridBagLayout());
        this.menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        /** Order Panel */
        this.rightPanel = new JPanel(new GridLayout(2, 1));
        this.rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        this.bottomPanel = new JTabbedPane();
        this.bottomPanel.setFont(this.bottomPanel.getFont().deriveFont(16.0f));

        /**
         * Group Components
         */
        /** Menu Items */
        HashMap<CafeCategories, ArrayList<Item>> items = CafeController.getItems();
        ArrayList<CafeCategories> categories = new ArrayList<>(items.keySet());

        DecimalFormat priceFormatter = new DecimalFormat("$0.00");

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
                this.menuPanel.add(new JLabel(priceFormatter.format(item.getPrice())), constraints);

                constraints.gridx = 0;
                constraints.gridy++;
                constraints.gridwidth = 2;
                constraints.anchor = GridBagConstraints.WEST;
                this.menuPanel.add(new JLabel(item.getDescription()), constraints);
            }
        }

        this.add(new JScrollPane(this.menuPanel));

        /** Order Panel */
        /** Top */

        /** Bottom */
        this.rightPanel.add(bottomPanel);
        this.add(rightPanel);
    }

    @Override
    public void addController(Controller c) {
        CafeMainController controller = (CafeMainController) c;
        this.orderPanel = new OrderPanel(controller.order);
        this.rightPanel.add(orderPanel, 0);

        for (CafeCategories cat : CafeController.getItems().keySet()) {
            JPanel panel = new JPanel();

            for (Item item : CafeController.getItems().get(cat)) {
                JButton button = new JButton(item.getName());
                button.setFont(button.getFont().deriveFont(16.0f));
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        controller.order.add(item);
                    }

                });
                panel.add(button);
            }

            this.bottomPanel.add(cat.getName(), panel);
        }

        this.orderPanel.submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DecimalFormat priceFormatter = new DecimalFormat("$0.00");

                try {
                    controller.submit();
                    JOptionPane.showMessageDialog(null, "Order Submitted! Your account was charged "
                            + priceFormatter.format(controller.order.getTotal()), "Success", JOptionPane.PLAIN_MESSAGE);
                    Navigator.goToHome();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }

    public void update() {
        this.orderPanel.update();
    }

}
