package com.geNAZt.SwitchAnnounce;

import com.geNAZt.SwitchAnnounce.Config.SwitchAnnounceConfig;
import com.geNAZt.SwitchAnnounce.Listener.ServerSwitch;
import net.md_5.bungee.api.plugin.Plugin;

import java.util.logging.Level;

/**
 * Created for YEAHWH.AT
 * User: geNAZt (fabian.fassbender42@googlemail.com)
 * Date: 08.09.13
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
