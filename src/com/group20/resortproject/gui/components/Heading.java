package com.group20.resortproject.gui.components;

import java.awt.Font;

import javax.swing.JLabel;

public class Heading extends JLabel {

    public Heading(HeadingDefinition definition, String text) {
        Font font = this.getFont().deriveFont(definition.getWeight(), definition.getSize());
        this.setFont(font);
        this.setText(text);
    }

    public Heading(HeadingDefinition definition, String text, int constraints) {
        Font font = this.getFont().deriveFont(definition.getWeight(), definition.getSize());
        this.setFont(font);
        this.setText(text);
        this.setHorizontalAlignment(constraints);
    }

    public static final HeadingDefinition H1 = new HeadingDefinition(36, Font.BOLD);
    public static final HeadingDefinition H2 = new HeadingDefinition(28, Font.BOLD);
    public static final HeadingDefinition H3 = new HeadingDefinition(22, Font.BOLD);
    public static final HeadingDefinition H4 = new HeadingDefinition(20, Font.PLAIN);
    public static final HeadingDefinition H5 = new HeadingDefinition(18, Font.PLAIN);
    public static final HeadingDefinition H6 = new HeadingDefinition(16, Font.PLAIN);

}

class HeadingDefinition {
    private final float size;
    private final int weight;

    HeadingDefinition(float size, int weight) {
        this.size = size;
        this.weight = weight;
    }

    public float getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
}
