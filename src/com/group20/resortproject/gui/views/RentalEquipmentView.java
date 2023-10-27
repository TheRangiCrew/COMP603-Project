package com.group20.resortproject.gui.views;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.group20.resortproject.Controller;
import com.group20.resortproject.equipment.EquipmentType;
import com.group20.resortproject.equipment.RentalEquipmentController;
import com.group20.resortproject.equipment.RentalItem;
import com.group20.resortproject.gui.components.Heading;
import com.group20.resortproject.gui.controllers.rentalequipment.RentalViewController;

public class RentalEquipmentView extends ViewPanel {

    private JPanel secondPanel;
    private JButton confirmButton;
    private RentalItem selectedItem;

    /**
     * the GUI for the rental equipment
     */
    public RentalEquipmentView() {

        this.confirmButton = new JButton("YES");

        // set box layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));

        // calls the rental equipment controller to initiate the rental equipment and
        // get a list of equipment items
        RentalEquipmentController.initRentalEquipment();

        Heading heading = new Heading(Heading.H4, "What equipment would you like to rent?");
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();

        // creates a button for each type of equipment and gives them all their own
        // action
        for (EquipmentType type : RentalEquipmentController.getItems().keySet()) {

            JButton equipmentButton = new JButton(type.getName());
            equipmentButton.setFont(equipmentButton.getFont().deriveFont(20f));
            equipmentButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            equipmentButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    setType(type);

                }

            });

            buttonPanel.add(equipmentButton);
        }

        this.secondPanel = new JPanel();

        this.add(Box.createVerticalGlue());
        this.add(heading);
        this.add(buttonPanel);
        this.add(secondPanel);
        this.add(Box.createVerticalGlue());

    }

    /**
     * using the selected equipmentType, adds a panal for more options for the
     * selected type and updates the UI as necessary
     * 
     * @param type the selected equipment
     */
    private void setType(EquipmentType type) {

        this.secondPanel.removeAll();

        if (type.getName() == "Taboggan") {

            this.secondPanel.add(new JLabel("Please pick a " + type.getName() + " colour:"));
        } else {

            this.secondPanel.add(new JLabel("Please pick a " + type.getName() + " size:"));
        }

        // creates a button for each size of the specified item
        for (RentalItem item : RentalEquipmentController.getItems().get(type)) {
            JButton sizeButton = new JButton(item.getEquipmentSize());
            sizeButton.setFont(sizeButton.getFont().deriveFont(20f));
            sizeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.secondPanel.add(sizeButton);
            sizeButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    confirmation(item);
                }
            });
        }

        this.secondPanel.revalidate();
        this.secondPanel.repaint();
    }

    /**
     * ask the user to confirm purchase
     * 
     * @param item
     */
    private void confirmation(RentalItem item) {

        this.selectedItem = item;

        this.secondPanel.removeAll();

        if (item.getEquipmentType() == EquipmentType.TABOGGAN) {

            this.secondPanel
                    .add(new JLabel("Are you sure you want to rent a " + item.getEquipmentSize() + " "
                            + item.getEquipmentType().getName() + " for $" + item.getEquipmentPrice() + "?"));
        } else {
            this.secondPanel
                    .add(new JLabel("Are you sure you want to rent a " + item.getName() + ", size "
                            + item.getEquipmentSize() + " for $" + item.getEquipmentPrice() + "?"));
        }

        JButton declineButton = new JButton("NO");
        confirmButton.setFont(confirmButton.getFont().deriveFont(20f));
        declineButton.setFont(declineButton.getFont().deriveFont(20f));
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        declineButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.secondPanel.add(confirmButton);
        this.secondPanel.add(declineButton);

        // if decline button is pressed, resets the UI
        declineButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                secondPanel.removeAll();
                secondPanel.revalidate();
                secondPanel.repaint();
            }
        });

        this.secondPanel.revalidate();
        this.secondPanel.repaint();
    }

    // when confirm button pressed, panel pop up confiming rental success, else
    // throws error panel
    @Override
    public void addController(Controller c) {
        RentalViewController controller = (RentalViewController) c;

        confirmButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.confirm(selectedItem);
                    JOptionPane.showMessageDialog(null, "Rental successful!", "Success", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
