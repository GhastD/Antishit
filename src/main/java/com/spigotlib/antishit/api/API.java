package com.spigotlib.antishit.api;

import com.spigotlib.antishit.Antishit;
import com.spigotlib.antishit.managers.PlayerDataManager;
import com.spigotlib.antishit.packet.TinyProtocolHandler;
import lombok.Getter;

/**
 * @author Ghast
 * @since 02-Nov-19
 * Ghast CC © 2019
 */
public class API {
    @Getter private final TinyProtocolHandler tinyProtocolHandler;
    @Getter private final PlayerDataManager playerDataManager;

    public API(){
        this.playerDataManager = new PlayerDataManager();
        this.tinyProtocolHandler = new TinyProtocolHandler(Antishit.INSTANCE.getPlugin());
    }
}
