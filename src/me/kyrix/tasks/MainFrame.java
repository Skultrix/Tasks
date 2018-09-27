package me.kyrix.tasks;

import me.kyrix.tasks.gfx.CustomComponents;
import me.kyrix.tasks.gfx.Theme;
import me.kyrix.tasks.gfx.panels.BasePanel;
import me.kyrix.tasks.gfx.panels.ContentSwitcher;
import me.kyrix.tasks.gfx.panels.TitleBarPanel;
import me.kyrix.tasks.taskmanagement.Group;
import me.kyrix.tasks.taskmanagement.GroupManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    private static MainFrame main;

    private static GroupManager groupManager;
    private static Group inbox;
    private static BasePanel basePanel;

    public MainFrame(int width, int height) {
        main = this;
        groupManager = new GroupManager();
        inbox = new Group("Inbox");
        groupManager.currentGroup = inbox;
        basePanel = new BasePanel();

        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(width, height));
        insertContent();
        setResizable(false);
        getContentPane().setBackground(Theme.BASE_GRAY);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void insertContent() {
        setLayout(new BorderLayout());
        add(new TitleBarPanel(), BorderLayout.NORTH);
        add(basePanel, BorderLayout.CENTER);
    }

    public static GroupManager getGroupManager() {
        return groupManager;
    }
    public static MainFrame getInstance() {
        return main;
    }
    public static Group getInboxGroup() { return inbox; }
    public static BasePanel getBasePanel() {return basePanel; }

}
