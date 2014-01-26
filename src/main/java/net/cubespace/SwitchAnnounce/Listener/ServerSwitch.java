package net.cubespace.SwitchAnnounce.Listener;

import net.cubespace.SwitchAnnounce.FontFormat;
import net.cubespace.SwitchAnnounce.SwitchAnnounce;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.ArrayList;

/**
 * @author geNAZt
 */
public class ServerSwitch implements Listener {
    private ArrayList<ProxiedPlayer> joined = new ArrayList<>();

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
            message = FontFormat.translateString(message);

            for(ProxiedPlayer player1 : ProxyServer.getInstance().getPlayers()) {
                player1.sendMessage(message);
            }
        }
    }
}
