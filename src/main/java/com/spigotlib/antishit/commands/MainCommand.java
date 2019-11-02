package com.spigotlib.antishit.commands;

import com.spigotlib.antishit.api.command.AbstractCommand;
import com.spigotlib.antishit.api.command.AbstractSubCommand;
import com.spigotlib.antishit.api.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ghast
 * @since 02-Nov-19
 * Ghast CC © 2019
 */

@Command(name= "shit", permission = "shit.shit", aliases = "")
public class MainCommand extends AbstractCommand {

    @Override
    public void run(CommandSender executor, String... args) {

    }

    @Override
    public List<AbstractSubCommand> initSubCommands() {
        return Arrays.asList(

        );
    }
}
