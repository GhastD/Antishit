package com.spigotlib.antishit.api.command;

import com.spigotlib.antishit.utils.chat.Chat;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author Ghast
 * @since 18-Oct-19
 * Ghast CC © 2019
 */
@RequiredArgsConstructor
public class CommandListener implements CommandExecutor {

    private final AbstractCommand abstractCommand;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        switch (args.length){
            case 0: {
                if (sender.hasPermission(abstractCommand.getPermission())){
                    abstractCommand.run(sender);
                } else {
                    sender.sendMessage(Chat.translate("&4No permission!"));
                }

                return true;
            }
            case 1: {
                AbstractSubCommand sub = abstractCommand.getAbstractSubCommands().stream().filter(sls -> sls.getName().equalsIgnoreCase(args[0])).findFirst().orElse(null);
                if (sub != null) {
                    if (sender.hasPermission(sub.getPermission())) {
                        sub.run(sender);
                    } else {
                        sender.sendMessage(Chat.translate("&4No permission!"));
                    }
                } else {
                    if (sender.hasPermission(abstractCommand.getPermission())) {
                        abstractCommand.run(sender, args);
                    } else {
                        sender.sendMessage(Chat.translate("&4No permission!"));
                    }
                }

                return true;
            }
            default: {

                AbstractSubCommand sub = abstractCommand.getAbstractSubCommands().stream().filter(sls -> sls.getName().equalsIgnoreCase(args[0])).findFirst().orElse(null);
                if (sub != null) {
                    if (sender.hasPermission(sub.getPermission())) {
                        String vars[] = new String[args.length - 1];
                        for (int i = 1; i < (args.length); i++) {
                            vars[i - 1] = args[i];
                        }
                        sub.run(sender, vars);
                    } else {
                        sender.sendMessage(Chat.translate("&4No permission!"));
                    }
                } else {
                    if (sender.hasPermission(abstractCommand.getPermission())){
                        abstractCommand.run(sender);
                    } else {
                        sender.sendMessage(Chat.translate("&4No permission!"));
                    }
                }

            }
        }
        return false;
    }
}
