package me.kyrix.tasks.taskmanagement;

import me.kyrix.tasks.MainFrame;
import me.kyrix.tasks.gfx.Theme;
import me.kyrix.tasks.Utilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Group {
    //public Map<String, Task> taskList = new HashMap<String, Task>();
    public List<Task> taskList = new ArrayList<>();
    private String name;
    public Group(String name) {
        this.name = name;
        MainFrame.getGroupManager().addGroup(name, this);
    }
    public Task addTask(String desc) {
        Task newTask = new Task(desc);
        taskList.add(newTask);
        newTask.setID(taskList.indexOf(newTask));
        return newTask;
    }
    public Task getTask(int ID) {
        return taskList.get(ID);
    }
    public void removeTask(int ID) {
        taskList.remove(ID);
    }
    public JPanel groupPane() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
        p.setPreferredSize(Utilities.newSize(p, 200, 100));
        p.setBorder(new EmptyBorder(5, 10, 0, 10));
        p.setBackground(Theme.SPECIAL);
        p.add(new JLabel(this.getGroupTitle()));
        p.add(Box.createHorizontalGlue());
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        return p;
    }
    public String getGroupTitle() {
        return name;
    }
}
