package pbtservers.temporiza2r.utilidades;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import pbtservers.temporiza2r.Temporiza2r;

public class Reloj {

    BossBar interfaz;

    Plugin plugin = Temporiza2r.getPlugin(Temporiza2r.class);

    int tiempo;
    int taskID;

    public void ConfigurarTemporizador(int amount) {

        plugin.getConfig().set("TemporizadorActivo", true);

        interfaz = Bukkit.getServer().createBossBar(ChatColor.LIGHT_PURPLE + "<--" + ChatColor.GOLD + ChatColor.BOLD + " Temporizador Activo! "  + ChatColor.LIGHT_PURPLE + "-->", BarColor.BLUE, BarStyle.SOLID);

        tiempo = amount;

        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {

            boolean TemporizadorActivo = plugin.getConfig().getBoolean("TemporizadorActivo");

            for (Player Jugadores : Bukkit.getOnlinePlayers()) {
                //Jugadores.sendMessage("Temporizador Activo!"); (Debug)

                interfaz.addPlayer(Jugadores);
                interfaz.setProgress(1.0);
                interfaz.setTitle(ChatColor.RED + "<--" + ChatColor.GOLD + ChatColor.BOLD + " [" + "Tiempo Restante: " + ChatColor.GREEN + ChatColor.BOLD + String.format("%02d:%02d:%02d", tiempo / 3600, (tiempo % 3600) / 60, (tiempo % 60)) + ChatColor.GOLD + ChatColor.BOLD + "] " + ChatColor.RED + "-->");
                interfaz.setVisible(true);

            }

            if (tiempo == 0) {
                PararTemporizador();
                interfaz.setVisible(false);
            } else if (!TemporizadorActivo) {
                PararTemporizador();
                interfaz.setVisible(false);
            }

            tiempo--;
        }, 0L, 20L);
    }

    public void PararTemporizador() {
        Bukkit.getScheduler().cancelTask(taskID);
        plugin.getConfig().set("TemporizadorActivo", false);
    }

}
