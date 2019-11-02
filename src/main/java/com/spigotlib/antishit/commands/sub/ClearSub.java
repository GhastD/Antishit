package com.spigotlib.antishit.commands.sub;

import cc.ghast.antishit.utils.chat.Chat;
import com.spigotlib.antishit.Antishit;
import com.spigotlib.antishit.api.check.AbstractCheck;
import com.spigotlib.antishit.api.command.AbstractSubCommand;
import com.spigotlib.antishit.api.command.SubCommand;
import com.spigotlib.antishit.data.PlayerData;
import com.spigotlib.antishit.utils.hastebin.Hastebin;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

/**
 * @author Ghast
 * @since 02-Nov-19
 * Ghast CC © 2019
 */

@SubCommand(name = "clear", permission = "shit.clear", aliases = "")
public class ClearSub extends AbstractSubCommand {

    @Override
    public void run(CommandSender executor, String... args) {
        if (!(executor instanceof Player)) {
            executor.sendMessage("Player only command!");
            return;
        }
        Player player = (Player) executor;
        PlayerData data = Antishit.INSTANCE.getApi().getPlayerDataManager().getData(player);

        switch (args.length){
            case 1: {
                AbstractCheck target = data.getCheckManager().getChecks().stream().filter(check -> check.getId().equalsIgnoreCase(args[0])).findFirst().orElse(null);
                if (target == null){
                    player.sendMessage(Chat.translate("&4Invalid check! Make sure it is a valid criteria"));
                    return;
                }
                player.sendMessage(Chat.translate("&aSuccess! &7-> &e" + target.getLog().size() + " &a removed!"));
                target.getLog().clear();
            }
        }
    }
}
