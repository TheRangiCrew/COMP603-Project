package com.group20.resortproject.components;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.group20.resortproject.Navigator;

public class TopBar extends JPanel {

    private JButton backButton;
    private JLabel label;

    public TopBar() {
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(20, 10, 20, 100));

        this.backButton = new JButton("Back");
        this.backButton.setEnabled(false);
        this.backButton.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                Navigator.goToPrev();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        this.add(this.backButton, BorderLayout.WEST);

        this.label = new JLabel("");
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
        this.label.setVerticalAlignment(SwingConstants.CENTER);
        this.add(this.label, BorderLayout.CENTER);
    }

    public void update() {
        this.backButton.setEnabled(Navigator.hasPrevious());
        this.label.setText(Navigator.getCurrent().getName());
    }

}
