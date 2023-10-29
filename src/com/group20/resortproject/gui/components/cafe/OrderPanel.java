package com.group20.resortproject.gui.components.cafe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.group20.resortproject.cafe.Order;
import com.group20.resortproject.cafe.OrderItem;
import com.group20.resortproject.gui.components.Heading;

/**
 * Displays all items within in an order and an order's information
 */
public class OrderPanel extends JPanel {

    private Order order;

    private JPanel itemListPanel;
    private JPanel totalPanel;
    private JLabel totalItems;
    private Heading totalCost;
    public JButton submitButton;

    public OrderPanel(Order order) {
        /**
         * Setup
         */
        this.order = order;

        this.setLayout(new BorderLayout());

        /**
         * Header
         */
        Heading heading = new Heading(Heading.H5, "Place Order", SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.add(heading, BorderLayout.NORTH);

        /**
         * List of items in an order
         */
        this.itemListPanel = new JPanel(new GridBagLayout());
        this.itemListPanel.setBackground(Color.WHITE);
        this.add(itemListPanel);

        /**
         * Statistics about the order (total items, total cost)
         */
        this.totalPanel = new JPanel(new GridBagLayout());

        this.totalItems = new JLabel();
        this.totalCost = new Heading(Heading.H5, "");

        // Generate all ItemPanels for the order
        this.generateItemPanels();

        // "Submit" button
        this.submitButton = new JButton("Purchase");
        this.submitButton.setFont(submitButton.getFont().deriveFont(14.0f));

        GridBagConstraints constraints = new GridBagConstraints();

        // Initial layout settings for the totalPanel
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 10, 5, 10);
        /**
         * Construct the totalPanel
         */
        this.totalPanel.add(submitButton, constraints);

        constraints.gridx++;
        this.totalPanel.add(this.totalItems, constraints);

        constraints.gridx++;
        constraints.anchor = GridBagConstraints.EAST;
        this.totalPanel.add(this.totalCost, constraints);

        this.add(this.totalPanel, BorderLayout.SOUTH);
    }

    /**
     * Update the panels to reflect the current state of the order
     */
    public void update() {
        this.generateItemPanels();
        this.revalidate();
        this.repaint();
    }

    /**
     * Generate all the ItemPanels for the items within the order
     * 
     * @see ItemPanel
     */
    private void generateItemPanels() {
        // Remove all existing panels
        this.itemListPanel.removeAll();

        // Format a float into a dollar value
        DecimalFormat priceFormatter = new DecimalFormat("$0.00");

        GridBagConstraints constraints = new GridBagConstraints();

        // Initial GridBagLayout settings
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.weightx = 1;

        // For each item in the order render an ItemPanel
        for (OrderItem item : order.getItems()) {
            ItemPanel panel = new ItemPanel(item, order);
            this.itemListPanel.add(panel, constraints);
            constraints.gridy++;
        }

        // Set the labels for the total items and total cost of the order
        this.totalItems.setText(order.getItemCount() + " item" + (order.getItemCount() == 1 ? "" : "s"));
        this.totalCost.setText(priceFormatter.format(order.getTotal()));

    }

}
