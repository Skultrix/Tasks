package me.kyrix.tasks.gfx.panels;

import me.kyrix.tasks.Utilities;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JPanel {
    private GroupsPanel groupsPanel;
    private static ContentSwitcher contentSwitcher;
    public BasePanel() {
        groupsPanel = new GroupsPanel();
        contentSwitcher = new ContentSwitcher();
        setLayout(new BorderLayout());
        add(groupsPanel, BorderLayout.WEST);
        add(contentSwitcher, BorderLayout.CENTER);
    }
    public GroupsPanel getGroupsPanel() {
        return groupsPanel;
    }
    public ContentSwitcher getContentSwitcher() {return contentSwitcher;}
}
