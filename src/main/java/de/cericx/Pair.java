package de.cericx;

import javax.swing.*;
import java.awt.*;

public class Pair {

    JComponent jComponent;
    JComponent jComponent1;

    public Pair(JComponent jComponent, JComponent jComponent1) {
        this.jComponent = jComponent;
        this.jComponent1 = jComponent1;
    }

    public JPanel getAsJPanel() {
        JPanel jPanel = new JPanel();
        jPanel.add(jComponent, BorderLayout.WEST);
        jPanel.add(jComponent1, BorderLayout.EAST);
        return jPanel;
    }

    public void setjComponent(JComponent jComponent) {
        this.jComponent = jComponent;
    }

    public JComponent getjComponent() {
        return jComponent;
    }

    public void setjComponent1(JComponent jComponent1) {
        this.jComponent1 = jComponent1;
    }

    public JComponent getjComponent1() {
        return jComponent1;
    }
}
