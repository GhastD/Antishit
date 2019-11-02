package com.spigotlib.antishit.api.command;

import lombok.Getter;
import org.bukkit.command.CommandSender;

/**
 * @author Ghast
 * @since 18-Oct-19
 * Ghast CC © 2019
 */


public abstract class AbstractSubCommand {
    @Getter private String name = this.getClass().getAnnotation(SubCommand.class).name();
    @Getter private String permission = this.getClass().getAnnotation(SubCommand.class).permission();

    public abstract void run(CommandSender executor, String... args);
}
