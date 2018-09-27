package me.kyrix.tasks.gfx;

import java.awt.*;
import java.io.File;
import java.net.URL;

public class FontManager {

    public static FontManager fontManager = new FontManager();

    public static final int NORMAL = 1;
    public static final int BOLD = 2;
    public static final int LIGHT = 3;

    public Font getMainFont(int style) {
        String path = "/me/kyrix/tasks/resources/fonts/TitilliumWeb-*.ttf";
        URL url = null;
        if (style == NORMAL) {
             url = getClass().getResource(path.replace("*", "Regular"));
        } else if (style == BOLD) {
            url = getClass().getResource(path.replace("*", "Bold"));
        } else if (style == LIGHT) {
            url = getClass().getResource(path.replace("*", "Light"));
        }

        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(url.toURI()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static FontManager getFontManager() {
        return fontManager;
    }
}
