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
            //if (!sender.hasPermission("command.t2r")) return Collections.EMPTY_LIST;
            final List<String> oneArgList = new ArrayList<>();
            final List<String> completions = new ArrayList<>();

            if (args.length == 1){
                StringUtil.copyPartialMatches(args[0], oneArgList, completions);
            }
            if (args.length == 2){
                return null;
                // Returns null to get all online players
            }
            Collections.sort(completions);
            return completions;
        }
        return Collections.EMPTY_LIST;
    }

}
