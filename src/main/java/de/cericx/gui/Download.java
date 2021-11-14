package de.cericx.gui;

import de.cericx.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Download extends JPanel {

    public Download(String selected, String javaHome, int serverPort) throws IOException, InterruptedException {
        Main.getFrame().setTitle("Downloading version " + selected);
        setLayout(new BorderLayout());
        String file = "spigot-1.17.1.jar";

        switch (selected) {
            case "1.8":
                file = "https://cdn.getbukkit.org/spigot/spigot-1.8.8-R0.1-SNAPSHOT-latest.jar";
                break;
            case "1.9":
                file = "https://cdn.getbukkit.org/spigot/spigot-1.9.4-R0.1-SNAPSHOT-latest.jar";
                break;
            case "1.10":
                file = "https://cdn.getbukkit.org/spigot/spigot-1.10.2-R0.1-SNAPSHOT-latest.jar";
                break;
            case "1.11":
                file = "https://cdn.getbukkit.org/spigot/spigot-1.11.2.jar";
                break;
            case "1.12":
                file = "https://cdn.getbukkit.org/spigot/spigot-1.12.2.jar";
                break;
            case "1.13":
                file = "https://cdn.getbukkit.org/spigot/spigot-1.13.2.jar";
                break;
            case "1.14":
                file = "https://cdn.getbukkit.org/spigot/spigot-1.14.4.jar";
                break;
            case "1.15":
                file = "https://cdn.getbukkit.org/spigot/spigot-1.15.2.jar";
                break;
            case "1.16":
                file = "https://cdn.getbukkit.org/spigot/spigot-1.16.5.jar";
                break;
            default:
            case "1.17":
                file = "https://download.getbukkit.org/spigot/spigot-1.17.1.jar";
                break;
        }


        URL url = new URL(file);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream in = null;
        String filename = "spigot.jar";
        filename = filename.substring(filename.lastIndexOf('/') + 1);
        FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + File.separator + filename);
        in = connection.getInputStream();
        int read = -1;
        int i = 0;
        byte[] buffer = new byte[4096];
        while ((read = in.read(buffer)) != -1) {
            i++;
            out.write(buffer, 0, read);
            System.out.println("Current download Progress: " + i);
        }
        in.close();
        out.close();

        File eula = new File("eula.txt");
        eula.createNewFile();
        FileWriter fileWriter = new FileWriter(eula);
        fileWriter.append("eula=true");
        fileWriter.close();

        File start = new File("start.bat");
        start.createNewFile();
        FileWriter startWriter = new FileWriter(start);
        System.out.println(javaHome);
        System.out.println(selected);
        startWriter.append("@echo off\n")
                   .append("SET version=" + selected + "\n")
                   .append("color 02\n")
                   .append("echo Starting on %version%\n")
                   .append("title Spigot %version%\n")
                   .append(":start\n")
                   .append("\"" + javaHome + "\\bin\\java.exe\" -Xmx1024M -jar spigot.jar nogui\n")
                   .append("goto start\n");
        startWriter.close();

        File server_properties = new File("server.properties");
        FileWriter properties = new FileWriter(server_properties);
        properties.append("server-port="+serverPort);
        properties.close();

        add(new JLabel("<html>Your download has been finished.<br/>To start the server simply run the start.bat file.<br/>You can close this window now.</html>"));
        //Main.getFrame().add(new ServerProperties());
        JButton button = new JButton("close");
        add(button, BorderLayout.SOUTH);
        Download download = this;
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Main.getFrame().remove(download);
                //Main.getFrame().add(new Finished());
                //Main.getFrame().setVisible(true);
                System.exit(0);
            }
        });
    }
}
