package com.geNAZt.SwitchAnnounce.Listener;

import com.geNAZt.SwitchAnnounce.SwitchAnnounce;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created for YEAHWH.AT
 * User: geNAZt (fabian.fassbender42@googlemail.com)
 * Date: 08.09.13
 */
public class ServerSwitch implements Listener {
    private ArrayList<ProxiedPlayer> joined = new ArrayList<ProxiedPlayer>();

    @EventHandler
    public void onProxyJoin(final PostLoginEvent event) {
        joined.add(event.getPlayer());
    }

    @EventHandler
    public void onServerChange(ServerSwitchEvent event) {
        if(joined.contains(event.getPlayer())) {
            joined.remove(joined.indexOf(event.getPlayer()));

            return;
        }

        if(SwitchAnnounce.getConfig().Enabled) {
            String newServer = event.getPlayer().getServer().getInfo().getName();
            String player = event.getPlayer().getName();

            String message = SwitchAnnounce.getConfig().SwitchString;
            message = message.replace("%player", player);
            message = message.replace("%server", newServer);

            for(ProxiedPlayer player1 : ProxyServer.getInstance().getPlayers()) {
                player1.sendMessage(message);
            }
        }
    }
}
