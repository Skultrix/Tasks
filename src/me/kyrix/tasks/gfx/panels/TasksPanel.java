package me.kyrix.tasks.gfx.panels;

import me.kyrix.tasks.MainFrame;
import me.kyrix.tasks.Utilities;
import me.kyrix.tasks.gfx.CustomComponents;
import me.kyrix.tasks.gfx.FontManager;
import me.kyrix.tasks.gfx.ImageUtils;
import me.kyrix.tasks.gfx.Theme;
import me.kyrix.tasks.taskmanagement.Group;
import me.kyrix.tasks.taskmanagement.Task;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class TasksPanel extends JPanel {
    public TasksPanel(Group group) {
        setLayout(new BorderLayout());
        setBackground(Theme.DARK_GRAY);
        if (group != null) {
            TasksTopRow topRow = new TasksTopRow(group);
            add(topRow, BorderLayout.NORTH);
            if (group.taskList.isEmpty()) {
                add(noTasks(group), BorderLayout.CENTER);
            } else {
                add(center(group), BorderLayout.CENTER);
            }
            add(addTaskRow(group), BorderLayout.SOUTH);
        } else {

        }
    }
    private JPanel noTasks(Group group) {
        JPanel p = new JPanel();
        p.setBackground(Theme.DARK_GRAY2);
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(100, 50, 100, 50),
                BorderFactory.createDashedBorder(Theme.BASE_GRAY.brighter(), 10, 3)
        ));
        p.setLayout(new GridBagLayout());
        JLabel label = CustomComponents.createBaseLabel(26, false,
                "You have no tasks in " + group.getGroupTitle() + ".",
                Theme.LIGHT_GRAY.brighter());
        //label.setFont(FontManager.getFontManager().getMainFont(FontManager.LIGHT).deriveFont(26f));
        p.add(label);
        return p;
    }
    private JScrollPane center(Group group) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBackground(Theme.DARK_GRAY2);
        for (Task task : group.taskList) {
            p.add(task.taskPane());
        }
        JScrollPane pane = new JScrollPane(p);
        Border b = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        pane.setViewportBorder(b);
        pane.setBorder(b);
        pane.setBackground(Theme.DARK_GRAY);
        return pane;
    }
    private JScrollPane centerModded(Group group) {
        JScrollPane p = new JScrollPane();
        p.setLayout(new ScrollPaneLayout());
        p.setBackground(Theme.DARK_GRAY2);
        for (Task task : group.taskList) {
            p.add(task.taskPane());
        }
        Border b = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        p.setViewportBorder(b);
        p.setBorder(b);
        return p;
    }
    private JPanel addTaskRow(Group group) {
        JPanel p = new JPanel();
        p.setBackground(Theme.DARK_GRAY);
        p.setPreferredSize(Utilities.newSize(p, -1, 50));
        p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(7, 10, 7, 10, Theme.DARK_GRAY2),
                BorderFactory.createMatteBorder(0, 0, 5, 0, Theme.DARK_GRAY2_SHADOW)
        ));

        JButton addBtn = CustomComponents.createBaseButton(32, 32,
                "/me/kyrix/tasks/resources/images/plusfinal.png",
                null);

        ImageIcon noFocusIcon = ImageUtils.getInstance().createImageIcon("/me/kyrix/tasks/resources/images/plusfinal.png");
        noFocusIcon.setImage(ImageUtils.changeColor(noFocusIcon, Theme.SPECIAL.darker().darker()).getImage());

        addBtn.setIcon(noFocusIcon);

        JTextField newTaskDesc = new JTextField();
        newTaskDesc.setBorder(new EmptyBorder(5, 10, 5, 10));
        newTaskDesc.setBackground(Theme.DARK_GRAY);
        newTaskDesc.setForeground(Theme.LIGHT_GRAY.brighter().brighter());
        newTaskDesc.setCaretColor(Theme.SPECIAL);
        newTaskDesc.setFont(FontManager.getFontManager().getMainFont(FontManager.NORMAL).deriveFont(16f));
        newTaskDesc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!newTaskDesc.getText().equals("") && e.getKeyCode() == 10) {
                    group.addTask(newTaskDesc.getText());
                    MainFrame.getBasePanel().getContentSwitcher().switchContent(ContentSwitcher.TASKS);
                }
            }
        });
        addBtn.addActionListener(e -> {
            if (!newTaskDesc.getText().equals("")) {
                group.addTask(newTaskDesc.getText());
                MainFrame.getBasePanel().getContentSwitcher().switchContent(ContentSwitcher.TASKS);
            }
        });
        p.add(newTaskDesc);
        p.add(addBtn);
        return p;
    }
    private class TasksTopRow extends JPanel {
        public TasksTopRow(Group group) {
            JLabel taskGroup = CustomComponents.createBaseLabel(
                    15,
                    true,
                    group.getGroupTitle(),
                    Theme.LIGHT_GRAY);
            JLabel taskNumber = new JLabel(String.valueOf(group.taskList.size()));


            this.setPreferredSize(Utilities.newSize(this, -1, 30));
            this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
            this.setBorder(new EmptyBorder(0, 10, 0, 10));
            this.setBackground(Theme.DARK_GRAY);

            this.add(taskGroup);
            this.add(Box.createHorizontalGlue());
            this.add(taskNumber);
        }
    }
}
