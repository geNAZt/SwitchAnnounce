package net.cubespace;

import net.cubespace.Config.SwitchAnnounceConfig;
import net.cubespace.Listener.ServerSwitch;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

/**
 * @author geNAZt
 */
public class SwitchAnnounce extends Plugin {
    private static SwitchAnnounceConfig config;
    private static SwitchAnnounce instance;

    public void onEnable() {
        try {
            // Initialize Config
            config = new SwitchAnnounceConfig(this);
            config.init();
        } catch(Exception ex) {
            getProxy().getLogger().log(Level.SEVERE, "FAILED TO LOAD CONFIG!!!", ex);
            return;
        }

        getProxy().getPluginManager().registerListener(this, new ServerSwitch());

        instance = this;
    }

    public static SwitchAnnounceConfig getConfig() {
        return config;
    }

    public static SwitchAnnounce getInstance() {
        return instance;
    }
}
