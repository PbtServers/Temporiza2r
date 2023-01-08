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

        if (args.length == 0) {
            if (JugadorBase instanceof Player) {
                Player Jugador = (Player) JugadorBase;
                Jugador.sendMessage(Jugador.getPlayer().getUniqueId(), "\u00a76\u00a7lTemporiza2r \u00a7b\u00a7lArgumentos \u00a77\u00a7l-->");
                Jugador.sendMessage(Jugador.getPlayer().getUniqueId(), "\u00a77--> \u00a7aCrear \u00a77(\u00a7a$Tiempo-en-Segundos\u00a77)");
                Jugador.sendMessage(Jugador.getPlayer().getUniqueId(), "\u00a77--> \u00a7aEliminar");
                Jugador.sendMessage(Jugador.getPlayer().getUniqueId(), "\u00a7b\u00a7lGracias por Confiar en \u00a7c\u00a7lPbt\u00a76\u00a7lServers\u00a7b\u00a7l! \u00a77-\u00a7c\u00a7lPbt");
            } else {
                JugadorBase.sendMessage("\u00a76\u00a7lTemporiza2r \u00a7b\u00a7lArgumentos \u00a77\u00a7l-->");
                JugadorBase.sendMessage("\u00a77--> \u00a7aCrear \u00a77(\u00a7a$Tiempo-en-Segundos\u00a77)");
                JugadorBase.sendMessage("\u00a77--> \u00a7aEliminar");
                JugadorBase.sendMessage("\u00a7b\u00a7lGracias por Confiar en \u00a7c\u00a7lPbt\u00a76\u00a7lServers\u00a7b\u00a7l! \u00a77-\u00a7c\u00a7lPbt");
            }
        } else if (args[0].equalsIgnoreCase("Crear")) {
            if (args.length != 2) {
                if (JugadorBase instanceof Player) {
                    Player Jugador = (Player) JugadorBase;
                    Jugador.sendMessage("\u00a77[\u00a76\u00a7lTemporiza2r\u00a77] " + "\u00a7c--> Falta un Segundo Argumento con el \u00a77(\u00a7a$Tiempo-en-Segundos\u00a77)");
                } else {
                    JugadorBase.sendMessage("\u00a77[\u00a76\u00a7lTemporiza2r\u00a77] " + "\u00a7c--> Falta un Segundo Argumento con el \u00a77(\u00a7a$Tiempo-en-Segundos\u00a77)");
                }
            } else {
                if (JugadorBase instanceof Player) {
                    Player Jugador = (Player) JugadorBase;
                    if (Jugador.hasPermission("temporiza2r.crear") | Jugador.isOp()) {
                        new Reloj().ConfigurarTemporizador(Integer.parseInt(args[1])-1);
                        Jugador.sendMessage("\u00a77[\u00a76\u00a7lTemporiza2r\u00a77] " + "\u00a7aTemporizador Configurado a " + args[1] + "s");
                    } else {
                        Jugador.sendMessage("\u00a77[\u00a76\u00a7lTemporiza2r\u00a77] " + "\u00a7cNo Tienes Permiso para Hacer Eso!");
                    }
                } else {
                    new Reloj().ConfigurarTemporizador(Integer.parseInt(args[1])-1);
                    JugadorBase.sendMessage("\u00a77[\u00a76\u00a7lTemporiza2r\u00a77] " + "\u00a7aTemporizador Configurado a " + args[1] + "s");
                }
            }
        } else if (args[0].equalsIgnoreCase("Eliminar")) {
            if (JugadorBase instanceof Player) {
                Player Jugador = (Player) JugadorBase;
                if (Jugador.hasPermission("temporiza2r.eliminar") | Jugador.isOp()) {
                    new Reloj().PararTemporizador();
                    Jugador.sendMessage("\u00a77[\u00a76\u00a7lTemporiza2r\u00a77] " + "\u00a7aTemporizador Eliminado");
                } else {
                    Jugador.sendMessage("\u00a77[\u00a76\u00a7lTemporiza2r\u00a77] " + "\u00a7cNo Tienes Permiso para Hacer Eso!");
                }
            } else {
                new Reloj().PararTemporizador();
                JugadorBase.sendMessage("\u00a77[\u00a76\u00a7lTemporiza2r\u00a77] " + "\u00a7aTemporizador Eliminado");
            }
        }
        return true;
    }
}
