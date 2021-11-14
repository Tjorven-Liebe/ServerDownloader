package de.cericx;

import javax.swing.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import de.cericx.gui.Setup;

public class Main extends JFrame {

    public static JFrame frame;
    static Setup setup;

    public Main() {
        setup = new Setup();
        add(setup);
        //add(new ServerProperties());
        setTitle("Download Server files");
        setSize(400, 450);

        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame = this;
        setVisible(true);

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatMaterialDeepOceanIJTheme.setup();
        UIManager.setLookAndFeel(new FlatMaterialDeepOceanIJTheme());
        new Main();
    }

    public static Setup getSelect() {
        return setup;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        Main.frame = frame;
    }
}
