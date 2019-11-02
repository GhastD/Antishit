package com.spigotlib.antishit.api.command;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * @author Ghast
 * @since 18-Oct-19
 * Ghast CC © 2019
 */
public abstract class AbstractCommand {

    @Getter private final String name = this.getClass().getAnnotation(Command.class).name();
    @Getter private final String permission = this.getClass().getAnnotation(Command.class).permission();
    @Getter @Setter private List<AbstractSubCommand> abstractSubCommands;

    public abstract void run(CommandSender executor, String... args);
    public abstract List<AbstractSubCommand> initSubCommands();


}
