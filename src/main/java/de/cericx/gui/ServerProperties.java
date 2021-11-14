package de.cericx.gui;

import de.cericx.Main;
import de.cericx.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerProperties extends JPanel {

    public ServerProperties() {
        String[] game_modes = {"survival", "creative", "adventure", "spectator"};
        String[] difficulty_modes = {"peaceful", "easy", "normal", "hard"};
        String[] bool = {"false", "true"};

        JComboBox enable_jmx_monitoring =           new JComboBox(bool); enable_jmx_monitoring.setSelectedIndex(0); enable_jmx_monitoring.setToolTipText("enable-jmd-monitoring");
        JSpinner rcon_port =                        new JSpinner();rcon_port.setValue(25575);
        JComboBox game_mode =                       new JComboBox(game_modes); game_mode.setSelectedIndex(0);
        JComboBox enable_command_block =            new JComboBox(bool); enable_command_block.setSelectedIndex(0);
        JComboBox enable_query =                    new JComboBox(bool); enable_query.setSelectedIndex(0);
        JTextField level_name =                     new JTextField("world");
        JTextField motd =                           new JTextField("A beatiful new Minecraft " + Setup.selected + " Server");
        JSpinner query_port =                       new JSpinner(); query_port.setValue(25565);
        JComboBox pvp =                             new JComboBox(bool); pvp.setSelectedIndex(1);
        JComboBox difficulty =                      new JComboBox(difficulty_modes); difficulty.setSelectedIndex(1);
        JSpinner network_compression_threshold =    new JSpinner(); network_compression_threshold.setValue(256);
        JComboBox require_resource_pack =           new JComboBox(bool); require_resource_pack.setSelectedIndex(0);
        JSpinner max_tick_time =                    new JSpinner(); max_tick_time.setValue(60000);
        JComboBox use_native_transport =            new JComboBox(bool); use_native_transport.setSelectedIndex(1);
        JSpinner max_players =                      new JSpinner(); max_players.setValue(20);
        JComboBox online_mode =                     new JComboBox(bool); online_mode.setSelectedIndex(1);
        JComboBox enable_status =                   new JComboBox(bool); enable_status.setSelectedIndex(1);
        JComboBox allow_flight =                    new JComboBox(bool); allow_flight.setSelectedIndex(0);
        JComboBox broadcast_rcon_to_ops =           new JComboBox(bool); broadcast_rcon_to_ops.setSelectedIndex(1);
        JSpinner view_distance =                    new JSpinner(); view_distance.setValue(10);
        JTextField server_ip =                      new JTextField();
        JTextField resource_pack_prompt =           new JTextField();
        JComboBox allow_nether =                    new JComboBox(bool); allow_nether.setSelectedIndex(1);
        JSpinner server_port =                      new JSpinner(); server_port.setValue(25565); server_port.setForeground(Color.red);
        JComboBox enable_rcon =                     new JComboBox(bool); enable_rcon.setSelectedIndex(0);
        JComboBox sync_chunk_writes =               new JComboBox(bool); sync_chunk_writes.setSelectedIndex(1);
        JSpinner op_permission_level =              new JSpinner(); op_permission_level.setValue(4);
        JComboBox prevent_proxy_connections =       new JComboBox(bool); prevent_proxy_connections.setSelectedIndex(0);
        JTextField resource_pack =                  new JTextField();
        JSpinner entity_broadcast_range_percentage= new JSpinner(); entity_broadcast_range_percentage.setValue(100);
        JTextField rcon_password =                  new JTextField();
        JSpinner player_idle_timeout =              new JSpinner(); player_idle_timeout.setValue(0);
        JComboBox debug =                           new JComboBox(bool); debug.setSelectedIndex(0);
        JComboBox force_gamemode =                  new JComboBox(bool); force_gamemode.setSelectedIndex(0);
        JSpinner rate_limit =                       new JSpinner(); rate_limit.setValue(0);
        JComboBox hardcore =                        new JComboBox(bool); hardcore.setSelectedIndex(0);
        JComboBox whitelist =                       new JComboBox(bool); whitelist.setSelectedIndex(0);
        JComboBox broadcast_constole_to_ops =       new JComboBox(bool); broadcast_constole_to_ops.setSelectedIndex(1);
        JComboBox spawn_npcs =                      new JComboBox(bool); spawn_npcs.setSelectedIndex(1);
        JComboBox spawn_animals =                   new JComboBox(bool); spawn_animals.setSelectedIndex(1);
        JComboBox snooper_enabled =                 new JComboBox(bool); snooper_enabled.setSelectedIndex(1);
        JSpinner function_permission_level =        new JSpinner(); function_permission_level.setValue(2);
        JTextField text_filtering_config =          new JTextField();
        JComboBox spawn_monsters =                  new JComboBox(bool); spawn_monsters.setSelectedIndex(1);
        JComboBox enforce_whitelist =               new JComboBox(bool); enforce_whitelist.setSelectedIndex(0);
        JTextField resource_pack_sha1 =             new JTextField();
        JSpinner spawn_protection =                 new JSpinner(); spawn_protection.setValue(16);
        JSpinner max_world_size =                   new JSpinner(); max_world_size.setValue(29999984);


        JPanel jPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;

        GridBagConstraints gbca = new GridBagConstraints();
        gbca.gridwidth = GridBagConstraints.REMAINDER;
        gbca.weightx = 1;
        gbca.fill = GridBagConstraints.HORIZONTAL;
       /* jPanel.add(new Pair(new JLabel("enable-jmx-monitoring"), enable_jmx_monitoring).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("rcon-port"), rcon_port).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("gamemode"), game_mode).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("enable-command-block"), enable_command_block).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("enable-query"), enable_query).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("level-name"), level_name).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("motd"), motd).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("query-port"), query_port).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("pvp"), pvp).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("difficulty"), difficulty).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("network-compression-threshold"), network_compression_threshold).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("require-resource-pack"), require_resource_pack).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("max-tick-time"), max_tick_time).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("user-native-transport"), use_native_transport).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("max-players"), max_players).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("online-mode"), online_mode).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("enable-status"), enable_status).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("allow-flight"), allow_flight).getAsJPanel());
        jPanel.add(new Pair(new JLabel("broadcast-rcon-to-ops"), broadcast_rcon_to_ops).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("view-distance"), view_distance).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("server-ip"), server_ip).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("resource-pack-prompt"), resource_pack_prompt).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("allow-nether"), allow_nether).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("server-port"), server_port).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("enable-rcon"), enable_rcon).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("sync-chunk-writes"), sync_chunk_writes).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("op-permission-level"), op_permission_level).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("prevent-proxy-connections"), prevent_proxy_connections).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("resource-pack"), resource_pack).getAsJPanel());
        jPanel.add(new Pair(new JLabel("entity-broadcast-range-percentage"), entity_broadcast_range_percentage).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("rcon.password"), rcon_password).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("player-idle-timeout"), player_idle_timeout).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("debug"), debug).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("force-gamemode"), force_gamemode).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("rate-limit"), rate_limit).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("hardcore"), hardcore).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("whitelist"), whitelist).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("broadcast-console-to-ops"), broadcast_constole_to_ops).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("spawn-npcs"), spawn_npcs).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("spawn-animals"), spawn_animals).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("snooper-enabled"), snooper_enabled).getAsJPanel());
        jPanel.add(new Pair(new JLabel("function-permission-level"), function_permission_level).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("text-filtering-config"), text_filtering_config).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("spawn-monsters"), spawn_monsters).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("enforce-whitelist"), enforce_whitelist).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("resource-pack-sha1"), resource_pack_sha1).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("spawn-protection"), spawn_protection).getAsJPanel(), gbca, 0);
        jPanel.add(new Pair(new JLabel("max-world-size"), max_world_size).getAsJPanel(), gbca, 0);
*/
        jPanel.setLayout(new FlowLayout());
        //jPanel.setPreferredSize(new Dimension(200, 300));
        JScrollPane scroller = new JScrollPane(jPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroller, BorderLayout.CENTER);

        JButton button = new JButton("Next");
        add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getFrame().remove(Setup.download);
                Main.getFrame().add(new ServerProperties());
                Main.getFrame().setVisible(true);
            }
        });
    }

}
