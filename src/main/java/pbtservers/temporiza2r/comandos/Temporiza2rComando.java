package pbtservers.temporiza2r.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pbtservers.temporiza2r.Temporiza2r;
import pbtservers.temporiza2r.utilidades.Reloj;

public class Temporiza2rComando implements CommandExecutor {

    @SuppressWarnings("unused")
    private final pbtservers.temporiza2r.Temporiza2r Temporiza2r;

    public Temporiza2rComando(Temporiza2r Temporiza2r) {
        this.Temporiza2r = Temporiza2r;
    }

    @Override
    public boolean onCommand(CommandSender JugadorBase, Command cmd, String label, String[] args) {

        boolean TemporizadorActivo = Temporiza2r.getConfig().getBoolean("TemporizadorActivo");

        if (args.length == 0) {
            if (JugadorBase instanceof Player) {
                Player Jugador = (Player) JugadorBase;
                Jugador.sendMessage(Jugador.getPlayer().getUniqueId(), "\u00a76\u00a7lTemporiza2r \u00a7b\u00a7lArgumentos \u00a77\u00a7l-->");
                Jugador.sendMessage(Jugador.getPlayer().getUniqueId(), "\u00a77\u00a7l--> \u00a77aCrear \u00a77(\u00a77a$Tiempo\u00a77)");
                Jugador.sendMessage(Jugador.getPlayer().getUniqueId(), "\u00a77\u00a7l--> \u00a77aEliminar");
                Jugador.sendMessage(Jugador.getPlayer().getUniqueId(), "\u00a7b\u00a7lGracias por Confiar en \u00a7c\u00a7lPbt\u00a76\u00a7lServers\u00a7b\u00a7l! \u00a77-\u00a7c\u00a7lPbt");
            } else {
                JugadorBase.sendMessage("\u00a76\u00a7lTemporiza2r \u00a7b\u00a7lArgumentos \u00a77\u00a7l-->");
                JugadorBase.sendMessage("\u00a77\u00a7l--> \u00a77aCrear \u00a77(\u00a77a$Tiempo-en-Segundos\u00a77)");
                JugadorBase.sendMessage("\u00a77\u00a7l--> \u00a77aEliminar");
                JugadorBase.sendMessage("\u00a7b\u00a7lGracias por Confiar en \u00a7c\u00a7lPbt\u00a76\u00a7lServers\u00a7b\u00a7l! \u00a77-\u00a7c\u00a7lPbt");
            }
        } else if (args[0].equalsIgnoreCase("Crear")) {
            new Reloj().ConfigurarTemporizador(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("Crear")) {
            new Reloj().PararTemporizador();
        }

        return true;
    }
}
