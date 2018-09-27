package me.kyrix.tasks.gfx;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickableJPanel extends JPanel {
    public ClickableJPanel() {
        super();
    }
    public void addActionListener(Runnable code) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                code.run();
            }
        });
    }
}
