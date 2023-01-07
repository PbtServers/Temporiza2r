package pbtservers.temporiza2r.utilidades;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pbtservers.temporiza2r.Temporiza2r;

public class Reloj {

    Plugin plugin = Temporiza2r.getPlugin(Temporiza2r.class);

    int tiempo;
    int taskID;

    public void ConfigurarTemporizador(int amount) {

        plugin.getConfig().set("TemporizadorActivo", true);

        tiempo = amount;

        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {

            boolean TemporizadorActivo = plugin.getConfig().getBoolean("TemporizadorActivo");

            for (Player Jugadores : Bukkit.getOnlinePlayers()) {
                Jugadores.sendMessage("Temporizador Activo!"); // Debug
            }

            if (tiempo == 0) {
                PararTemporizador();
            } else if (!TemporizadorActivo) {
                PararTemporizador();
            }

            tiempo--;
        }, 0L, 20L);
    }

    public void PararTemporizador() {
        Bukkit.getScheduler().cancelTask(taskID);
        plugin.getConfig().set("TemporizadorActivo", false);
    }

}
