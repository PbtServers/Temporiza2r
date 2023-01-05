package pbtservers.temporiza2r;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public final class Temporiza2r extends JavaPlugin {

    Temporiza2r instance = this;

    Logger log = Bukkit.getLogger();

    @Override
    public void onEnable() {
        log.info("Plugin Temporiza2r Habilitado!");
    }

    @Override
    public void onDisable() {
        log.info("Plugin Temporiza2r DesHabilitado!");
        this.saveConfig();
    }
}
