package cc.ghast.antishit;

import cc.ghast.antishit.api.API;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;


public class Antishit extends JavaPlugin {
    @Getter private static Antishit instance;
    @Getter private API api;

    public void onEnable(){
        instance = this;
        api = new API();

    }

    public void onDisable(){
        api.disinitManagers();
    }
}
