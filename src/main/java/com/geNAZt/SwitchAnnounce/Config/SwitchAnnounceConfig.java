package com.geNAZt.SwitchAnnounce.Config;

import com.geNAZt.SwitchAnnounce.SwitchAnnounce;
import net.craftminecraft.bungee.bungeeyaml.supereasyconfig.Config;

import java.io.File;

/**
 * Created for YEAHWH.AT
 * User: geNAZt (fabian.fassbender42@googlemail.com)
 * Date: 08.09.13
 */
public class SwitchAnnounceConfig extends Config {
    public SwitchAnnounceConfig(SwitchAnnounce plugin) {
        CONFIG_FILE = new File("plugins" + File.separator + plugin.getDescription().getName(), "config.yml");
        CONFIG_HEADER = "SwitchAnnoune by geNAZt";
    }

    public boolean Enabled = true;
    public String SwitchString = "%player switched to %server";
}
