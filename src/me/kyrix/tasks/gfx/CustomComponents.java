package me.kyrix.tasks.gfx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomComponents {

    public static JLabel createBaseLabel(float size, boolean bold, String label, Color color) {
        JLabel l = new JLabel(label);

        l.setFont(FontManager.getFontManager().getMainFont(bold ? FontManager.BOLD : FontManager.NORMAL).deriveFont(size));

        if (color != null) {
            l.setForeground(color);
        } else {
            l.setForeground(Theme.LIGHT_GRAY);
        }

        return l;
    }

    public static JButton createBaseButton(int width, int height, String imagePath, String label) {
        JButton b = new JButton();
        if (label != null) {
            b.setText(label);
        }
        if (imagePath != null) {
            ImageIcon icon = ImageUtils.getInstance().createImageIcon(imagePath);
            b.setIcon(icon);
        }
        b.setPreferredSize(new Dimension(width, height));
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);

        return b;
    }
    public static ClickableJPanel createClickablePanel() {
        return new ClickableJPanel();
    }
}
