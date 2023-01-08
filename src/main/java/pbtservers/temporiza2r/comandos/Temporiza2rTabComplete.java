package pbtservers.temporiza2r.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Temporiza2rTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (cmd.getName().equalsIgnoreCase("Temporiza2r") | cmd.getName().equalsIgnoreCase("t2r")) {
            if (!sender.hasPermission("temporiza2r.tabcomplete") | !sender.isOp()) return Collections.EMPTY_LIST;
            final List<String> oneArgList = new ArrayList<>();
            final List<String> completions = new ArrayList<>();

            oneArgList.add(0, "Crear");
            oneArgList.add(1, "Eliminar");

            if (args.length == 1){
                StringUtil.copyPartialMatches(args[0], oneArgList, completions);
            }
            if (args.length == 2){
                if (args[0].equalsIgnoreCase("Crear")) {
                    final List<String> CrearList = new ArrayList<>();
                    CrearList.add(0, "($Tiempo)");
                    StringUtil.copyPartialMatches(args[0], CrearList, completions);
                } else if (args[0].equalsIgnoreCase("Eliminar")) {
                    return null;
                }
            }
            Collections.sort(completions);
            return completions;
        }
        return Collections.EMPTY_LIST;
    }

}
