package com.group20.resortproject.gui.views.creditpass;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.group20.resortproject.Controller;
import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.components.Heading;
import com.group20.resortproject.gui.controllers.creditpass.LiftPassController;
import com.group20.resortproject.gui.views.ViewPanel;

public class LiftPassView extends ViewPanel {

    private JList<String> list;
    private JButton submit;

    public LiftPassView() {
        /**
         * Setup
         */
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 0, 10, 0);

        DefaultListModel<String> listItems = new DefaultListModel<>();
        listItems.add(0, "Beginner's Pass. One day, beginner slopes only.");
        listItems.add(1, "Single Day Pass. One day, full mountain access.");
        listItems.add(2, "Five Day Pass. Five days, full mountain access.");
        listItems.add(3, "Seven Day Pass. Seven days, full mountain access.");
        listItems.add(4, "Season Pass. Until end of season, full mountain access.");

        /**
         * Create Components
         */
        this.list = new JList<>(listItems);
        this.list.setSelectedIndex(0);
        this.list.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, (int) (0.2 * 255)), 1));

        this.submit = new JButton("Add Chosen Pass");

        /**
         * Group Components
         */
        this.add(Box.createVerticalGlue());
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(new Heading(Heading.H5, "Select a pass to add to your account. Be careful, you cannot change this:"),
                constraints);
        constraints.gridy++;
        this.add(this.list, constraints);
        constraints.gridy++;
        this.add(this.submit, constraints);
        this.add(Box.createVerticalGlue());

    }

    public int getSelectedIndex() {
        return this.list.getSelectedIndex();
    }

    public void addController(Controller c) {
        LiftPassController controller = (LiftPassController) c;

        this.submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.addLiftPass()) {
                    JOptionPane.showMessageDialog(null, "Your lift pass was successfully added!");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Something went wrong. Please contact a staff member for assistance.", "Oops...",
                            JOptionPane.WARNING_MESSAGE);
                }

                Navigator.goToPrev();
            }

        });
    }

}
