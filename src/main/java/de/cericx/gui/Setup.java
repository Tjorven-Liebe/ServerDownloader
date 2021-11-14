package de.cericx.gui;

import de.cericx.Find;
import de.cericx.Main;
import de.cericx.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Setup extends JPanel {

    public static String selected = "1.8";
    public static String javaHome = "";

    static Download download;

    public Setup() {
        //new Find();
        setLayout(null);
        final JLabel warn = new JLabel("<html><span style='color:red;'>Choose a (up to java 15) java installation folder</html>");
        String[] versions = {
                "1.8", "1.9", "1.10", "1.11", "1.12", "1.13", "1.14", "1.15", "1.16", "1.17"
        };
        JComboBox jComboBox = new JComboBox(versions);
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = jComboBox.getSelectedItem().toString();
                int version = Integer.parseInt(selected.split("\\.")[1]);
                if (version < 16) {
                    System.out.println(version);
                    warn.setText("<html><span style='color:red;'>Choose a (up to java 15) java installation folder</html>");
                    warn.updateUI();
                }else {
                    warn.setText("<html><span style='color:red;'>Choose a (at least java 16) java installation folder</html>");
                    warn.updateUI();
                }
                updateUI();
                repaint();
            }
        });
        JButton button = new JButton("Select!");

        JTextField javaHomeField = new JTextField(System.getProperty("java.home"));
        JButton chooseJavaHome = new JButton("Choose");
        chooseJavaHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                jFileChooser.setCurrentDirectory(new File(System.getProperty("java.home")));
                jFileChooser.setDialogTitle("Choose another Java runtime folder");
                int returnVal = jFileChooser.showOpenDialog(javaHomeField);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    javaHomeField.setText(jFileChooser.getSelectedFile().toString());
                }
            }
        });

        JComboBox jComboBox1 = new JComboBox();
        JButton jButton = new JButton("Select");

        //jComboBox1, jButton
        Pair pair = new Pair(javaHomeField, chooseJavaHome);
        JPanel panel = pair.getAsJPanel();

        JLabel label = new JLabel("<html><span style='color: red; text-align: center;'>By selecting, you agree with the minecraft eula</span><html>");


        JLabel server_port = new JLabel("Server-Port");
        JTextField port = new JTextField("25565");

        add(button);
        add(jComboBox);
        add(label);
        add(panel);
        add(warn);
        add(server_port);
        add(port);

        button.setBounds(10, 20, 360, 50);
        jComboBox.setBounds(10, 90, 360, 50);
        label.setBounds(65, 110, 360, 100);
        panel.setBounds(10, 170, 360, 30);
        warn.setBounds(70, 200, 360, 20);
        server_port.setBounds(60, 220, 180, 20);
        port.setBounds(120, 220, 200,20);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (javaHomeField.getText()!=null) {
                        javaHome = javaHomeField.getText();
                    }else javaHome = System.getProperty("java.home");
                    download = new Download(selected, javaHome, Integer.parseInt(port.getText()));

                    Main.getFrame().remove(Main.getSelect());
                    Main.getFrame().add(download);
                    Main.getFrame().setVisible(true);

                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        updateUI();
    }


}
