package me.kyrix.tasks.gfx.panels;

import me.kyrix.tasks.MainFrame;
import me.kyrix.tasks.Utilities;
import me.kyrix.tasks.gfx.ClickableJPanel;
import me.kyrix.tasks.gfx.CustomComponents;
import me.kyrix.tasks.gfx.ImageUtils;
import me.kyrix.tasks.gfx.Theme;
import me.kyrix.tasks.taskmanagement.Group;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GroupsPanel extends JPanel {

    public UserGroups groups;

    public GroupsPanel() {
        groups = new UserGroups();

        setBackground(Theme.DARKER_GRAY);
        setPreferredSize(Utilities.newSize(this, 200, -1));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(menu());
        add(groups);
    }
    private JPanel menu() {
        JPanel p = new JPanel();
        p.setBackground(Theme.DARKER_GRAY);
        p.setMaximumSize(Utilities.newSize(p, 200, 100));

        ClickableJPanel inbox = CustomComponents.createClickablePanel();
        inbox.setLayout(new BoxLayout(inbox, BoxLayout.LINE_AXIS));
        inbox.setPreferredSize(Utilities.newSize(inbox, 200, 40));
        inbox.setBackground(Theme.DARKER_GRAY);
        inbox.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Theme.LIGHT_GRAY, 1, false)
                ));

        JButton inboxIcon = CustomComponents.createBaseButton(24, 24,
                "/me/kyrix/tasks/resources/images/inbox.png", null);
        inboxIcon.setMaximumSize(new Dimension(24, 24));

        inbox.add(Box.createRigidArea(new Dimension(5, 0)));
        inbox.add(inboxIcon);
        inbox.add(Box.createRigidArea(new Dimension(5, 0)));
        inbox.add(CustomComponents.createBaseLabel(14, false, "Inbox", Color.WHITE.darker()));
        inbox.addActionListener(() -> {
            MainFrame.getGroupManager().currentGroup = MainFrame.getInboxGroup();
            MainFrame.getBasePanel().getContentSwitcher().switchContent(ContentSwitcher.TASKS);
        });

        ClickableJPanel settings = CustomComponents.createClickablePanel();
        settings.setLayout(new BoxLayout(inbox, BoxLayout.LINE_AXIS));
        settings.setPreferredSize(Utilities.newSize(inbox, 200, 40));
        settings.setBackground(Theme.DARKER_GRAY);
        settings.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createLineBorder(Theme.LIGHT_GRAY, 1, false)
        ));

        JButton settingsIcon = CustomComponents.createBaseButton(24, 24,
                "/me/kyrix/tasks/resources/images/inbox.png", null);
        settingsIcon.setMaximumSize(new Dimension(24, 24));

        settings.add(Box.createRigidArea(new Dimension(5, 0)));
        settings.add(settings);
        settings.add(Box.createRigidArea(new Dimension(5, 0)));
        settings.add(CustomComponents.createBaseLabel(14, false, "Inbox", Color.WHITE.darker()));
        settings.addActionListener(() -> {
            MainFrame.getGroupManager().currentGroup = MainFrame.getInboxGroup();
            MainFrame.getBasePanel().getContentSwitcher().switchContent(ContentSwitcher.TASKS);
        });


        p.add(inbox);
        p.add(Box.createRigidArea(new Dimension(0, 5)));
        p.add(settings);
        return p;
    }
    private void reload() {
        add(groups);
        revalidate();
        repaint();
    }
    public class UserGroups extends JPanel {
        public UserGroups() {
            setPreferredSize(Utilities.newSize(this, 200, 200));
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            setBackground(Color.WHITE);
            if (MainFrame.getGroupManager().groups.isEmpty()) {
                add(emptyUserGroups());
            } else {
                for (Group g : MainFrame.getGroupManager().groups.values()) {
                    if (!g.getGroupTitle().equals("Inbox"))
                        add(g.groupPane());
                }
            }
        }
        public void addGroup(JPanel p) {
            add(p);
            this.reload();
        }
        private void reload() {
            validate();
            repaint();
            GroupsPanel.this.reload();
        }
        private JPanel emptyUserGroups() {
            JPanel p = new JPanel();
            p.setBorder(new EmptyBorder(20, 20, 20, 20));
            p.add(new JLabel("Nothing here!"));
            p.setBackground(Theme.SPECIAL);
            return p;
        }
    }
}
