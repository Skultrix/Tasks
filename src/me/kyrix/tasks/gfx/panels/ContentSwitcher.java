package me.kyrix.tasks.gfx.panels;

import me.kyrix.tasks.MainFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.jar.JarFile;

public class ContentSwitcher extends JPanel {

    public static final int TASKS = 0;
    public static final int DASHBOARD = 1;
    public static final int SETTINGS = 2;

    public ContentSwitcher() {
        setLayout(new BorderLayout());
        //Default tasks group
        add(new TasksPanel(MainFrame.getInboxGroup()));
    }
    public void switchContent(int panel) {
        BorderLayout l = (BorderLayout) this.getLayout();
        remove(l.getLayoutComponent(BorderLayout.CENTER));
        if (panel == TASKS) {
            add(new TasksPanel(MainFrame.getGroupManager().currentGroup));

        }
        revalidate();
        repaint();
    }
}
