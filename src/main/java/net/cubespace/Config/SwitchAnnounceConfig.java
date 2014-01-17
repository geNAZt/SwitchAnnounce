package net.cubespace.Config;

import net.cubespace.SwitchAnnounce;
import net.craftminecraft.bungee.bungeeyaml.supereasyconfig.Config;

import java.io.File;

/**
 * @author geNAZt
 */
public class SwitchAnnounceConfig extends Config {
    public SwitchAnnounceConfig(SwitchAnnounce plugin) {
        CONFIG_FILE = new File("plugins" + File.separator + plugin.getDescription().getName(), "config.yml");
        CONFIG_HEADER = "SwitchAnnoune by geNAZt";
    }

    public boolean Enabled = true;
    public String SwitchString = "%player switched to %server";
}
