package com.spigotlib.antishit.managers;


import com.spigotlib.antishit.Antishit;
import com.spigotlib.antishit.api.command.AbstractCommand;
import com.spigotlib.antishit.api.command.CommandListener;
import com.spigotlib.antishit.commands.MainCommand;

import java.util.Arrays;

/**
 * @author Ghast
 * @since 18-Oct-19
 * Ghast CC © 2019
 */
public class CommandManager {


    public CommandManager() {init();}
    public void init() {
        Arrays.asList(new AbstractCommand[]{
                new MainCommand()
        }).forEach(abstractCommand -> {
            Antishit.INSTANCE.getPlugin().getCommand(abstractCommand.getName()).setExecutor(new CommandListener(abstractCommand));
            abstractCommand.setAbstractSubCommands(abstractCommand.initSubCommands());
        });
    }

}
