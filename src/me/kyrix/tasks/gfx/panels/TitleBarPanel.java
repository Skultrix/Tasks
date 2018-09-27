package me.kyrix.tasks.gfx.panels;

import me.kyrix.tasks.MainFrame;
import me.kyrix.tasks.Utilities;
import me.kyrix.tasks.gfx.CustomComponents;
import me.kyrix.tasks.gfx.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class TitleBarPanel extends JPanel {

    private static final String TITLE = "Tasks";

    private int posX = 0, posY = 0;

    public TitleBarPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBackground(Theme.DARK_GRAY.darker().darker());
        setPreferredSize(Utilities.newSize(this, -1, 23));
        //setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.DARK_GRAY2.darker()));

        addMouseListener(new TitleBarMouseAdapter());
        addMouseMotionListener(new TitleBarMouseMotionAdapter());

        JLabel titleLbl = CustomComponents.createBaseLabel(16, false, TITLE, Theme.LIGHT_GRAY);
        JButton minimizeBtn = CustomComponents.createBaseButton(16, 16, null, "b");
        JButton closeBtn = CustomComponents.createBaseButton(16, 16, null, "b");

        minimizeBtn.addActionListener(e -> MainFrame.getInstance().setState(JFrame.ICONIFIED));
        closeBtn.addActionListener(e -> System.exit(0));

        add(Box.createRigidArea(new Dimension(5, 0)));
        add(titleLbl);
        add(Box.createHorizontalGlue());
        add(minimizeBtn);
        add(Box.createRigidArea(new Dimension(5, 0)));
        add(closeBtn);
        add(Box.createRigidArea(new Dimension(5, 0)));
    }

    private class TitleBarMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            posX = e.getX();
            posY = e.getY();
        }
    }
    private class TitleBarMouseMotionAdapter extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent evt) {
            //sets frame position when mouse dragged
            MainFrame.getInstance().setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
        }
    }
}
