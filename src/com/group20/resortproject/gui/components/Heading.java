package com.group20.resortproject.gui.components;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * A helper class to provide JLabels similarly styled to HTML heading tags.
 * Examples:
 * <h1>Heading 1</h1>
 * <h2>Heading 2</h2>
 * <h4>Heading 4</h4>
 */
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

    // Definitions for different styles of headings
    public static final HeadingDefinition H1 = new HeadingDefinition(36, Font.BOLD);
    public static final HeadingDefinition H2 = new HeadingDefinition(28, Font.BOLD);
    public static final HeadingDefinition H3 = new HeadingDefinition(22, Font.BOLD);
    public static final HeadingDefinition H4 = new HeadingDefinition(20, Font.PLAIN);
    public static final HeadingDefinition H5 = new HeadingDefinition(18, Font.PLAIN);
    public static final HeadingDefinition H6 = new HeadingDefinition(16, Font.PLAIN);

}

/**
 * Heading style definitions
 */
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
