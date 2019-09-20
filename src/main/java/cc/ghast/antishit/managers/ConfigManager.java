package cc.ghast.antishit.managers;


import cc.ghast.antishit.api.manager.Manager;
import cc.ghast.antishit.utils.configuration.Configuration;
import lombok.Getter;

public class ConfigManager extends Manager {
    @Getter
    private static Configuration settings;

    public void init() {
        settings = new Configuration("settings.yml", antishit);
    }

    public void disinit(){
        settings.save();
    }

    public void reload(){
        settings.save();
        init();
    }
}
