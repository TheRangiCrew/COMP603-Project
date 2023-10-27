package com.group20.resortproject.gui.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import com.group20.resortproject.user.UserController;

public class RentalEquipmentView extends ViewPanel {

    private JPanel secondPanel;
    private JButton confirmButton;
    private RentalItem selectedItem;

    public RentalEquipmentView() {

        this.confirmButton = new JButton("YES");
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));

        RentalEquipmentController.initRentalEquipment();

        Heading heading = new Heading(Heading.H4, "What equipment would you like to rent?");
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();

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

    private void setType(EquipmentType type) {

        this.secondPanel.removeAll();

        if (type.getName() == "Taboggan") {

            this.secondPanel.add(new JLabel("Please pick a " + type.getName() + " colour:"));
        } else {

            this.secondPanel.add(new JLabel("Please pick a " + type.getName() + " size:"));
        }

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
