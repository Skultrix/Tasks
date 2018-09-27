package me.kyrix.tasks.taskmanagement;

import me.kyrix.tasks.MainFrame;
import me.kyrix.tasks.Utilities;
import me.kyrix.tasks.gfx.CustomComponents;
import me.kyrix.tasks.gfx.FontManager;
import me.kyrix.tasks.gfx.Theme;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Task {
    public int ID;
    public String description;
    public Task(String description) {
        this.description = description;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public JPanel taskPane() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
        p.setSize(Utilities.newSize(p, -1, 50));
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(7, 10, 0 , 10, Theme.DARK_GRAY2),
                BorderFactory.createMatteBorder(0, 0, 5, 0, Theme.DARK_GRAY2_SHADOW_TASKS)
        ));
        //p.setBorder(new EmptyBorder(10, 10, 10, 10));

        p.setBackground(Theme.DARK_GRAY_TASKS);

        JButton finishButton = CustomComponents.createBaseButton(40, 40, null, "R");
        JLabel descLabel = new JLabel(description);
        descLabel.setForeground(Theme.LIGHT_GRAY.brighter().brighter());
        descLabel.setFont(FontManager.getFontManager().getMainFont(FontManager.NORMAL).deriveFont((float) descLabel.getFont().getSize() + 3f));
        JButton settingsButton = CustomComponents.createBaseButton(40, 40, null, "S");


        p.add(finishButton);
        p.add(Box.createRigidArea(new Dimension(5, 0)));
        p.add(descLabel);
        p.add(Box.createHorizontalGlue());
        p.add(settingsButton);

        return p;
    }
}
