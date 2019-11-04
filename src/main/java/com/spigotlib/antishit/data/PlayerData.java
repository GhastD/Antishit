package com.spigotlib.antishit.data;


import com.spigotlib.antishit.api.check.AbstractCheck;
import com.spigotlib.antishit.api.check.CheckManager;
import com.spigotlib.antishit.utils.location.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerData {
    /*
        STAFF
    */
    public PlayerData(Player player){
        this.player = player;
        this.uuid = player.getUniqueId();
        this.checkManager = new CheckManager();
    }
    @NonNull
    @Getter private final Player player;
    @Getter private final UUID uuid;
    @Getter private final CheckManager checkManager;
}
