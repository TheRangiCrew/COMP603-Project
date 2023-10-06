package com.group20.resortproject.gui.components.TopBar;

import javax.swing.JButton;

import com.group20.resortproject.gui.Navigator;
import com.group20.resortproject.gui.Page;

public class TopBarButton extends JButton{
    
    private Page page;
    
    public TopBarButton(String text, Page page) {
        this.setText(text);
        this.page = page;
    }

    public void navigate() {
        Navigator.goTo(this.page);
    }
}
