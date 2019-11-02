package com.spigotlib.antishit;

import com.spigotlib.antishit.api.API;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Ghast
 * @since 02-Nov-19
 * Ghast CC © 2019
 */
@Getter
public enum Antishit {
    INSTANCE;

    private AntishitPlugin plugin;
    private API api;

    public void enable(AntishitPlugin plugin){
        this.plugin = plugin;
        this.api = new API();
    }
}
