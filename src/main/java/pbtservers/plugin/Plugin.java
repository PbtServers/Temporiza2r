package pbtservers.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public final class Plugin extends JavaPlugin {

    Plugin instance = this;

    Logger log = Bukkit.getLogger();

    @Override
    public void onEnable() {

        log.info("");

    }

    @Override
    public void onDisable() {
        log.info("Plugin Plugin DesHabilitado!");
        this.saveConfig();
    }
}
