package pbtservers.temporiza2r;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pbtservers.temporiza2r.comandos.Temporiza2rComando;
import pbtservers.temporiza2r.comandos.Temporiza2rTabComplete;

import java.util.Objects;
import java.util.logging.Logger;

public final class Temporiza2r extends JavaPlugin {

    Temporiza2r instance = this;

    Logger log = Bukkit.getLogger();

    @Override
    public void onEnable() {

        Temporiza2rComando Temporiza2rComando = new Temporiza2rComando(this);
        Temporiza2rTabComplete Temporiza2rTabComplete = new Temporiza2rTabComplete();
        Objects.requireNonNull(getCommand("Temporiza2r")).setExecutor(Temporiza2rComando);
        Objects.requireNonNull(getCommand("Temporiza2r")).setTabCompleter(Temporiza2rTabComplete);
        log.info("Plugin Temporiza2r Habilitado!");
    }

    @Override
    public void onDisable() {
        log.info("Plugin Temporiza2r DesHabilitado!");
        this.saveConfig();
    }
}
