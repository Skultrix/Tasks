package me.kyrix.tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Utilities {
    public static Dimension newSize(JPanel panel, int width, int height) {
        Dimension size = panel.getPreferredSize();
        if (width != -1) {
            size.width = width;
        }
        if (height != -1) {
            size.height = height;
        }
        return size;
    }




}
