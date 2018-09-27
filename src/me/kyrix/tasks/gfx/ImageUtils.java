package me.kyrix.tasks.gfx;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtils {
    private static ImageUtils imageUtils = new ImageUtils();
    public ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    public static Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public static ImageIcon changeColor(ImageIcon icon, Color color) {
        BufferedImage image = new BufferedImage(icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();

        for(int y = 0; y < image.getHeight(); y++)
            for(int x = 0; x < image.getWidth(); x++)
            {

                Color imageColor = new Color(image.getRGB(x, y));
                //mix imageColor and desired color
                int pixel = image.getRGB(x,y);
                if(!((pixel >> 24) == 0x00)) {
                    image.setRGB(x, y, color.getRGB());
                }

            }

        return new ImageIcon(image);
    }
    public static ImageUtils getInstance() {
        return imageUtils;
    }
}
