package com.spigotlib.antishit.managers;


import com.spigotlib.antishit.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerDataManager  {
    private HashMap<Player, PlayerData> playerData = new HashMap<>();

    public PlayerData getData(Player player){
        return playerData.computeIfAbsent(player, PlayerData::new);
    }

    public void init(){
        Bukkit.getOnlinePlayers().forEach(player -> playerData.computeIfAbsent(player, PlayerData::new));
    }

    public void disinit(){
        playerData.clear();
    }
}
