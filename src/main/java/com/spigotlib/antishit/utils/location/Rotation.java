package com.spigotlib.antishit.utils.location;

import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 28-Oct-19
 * Ghast CC © 2019
 */
@Getter
public class Rotation {
    private Player player;
    private float pitch;
    private float yaw;

    public Rotation(Player player, float pitch, float yaw){
        this.player = player;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    // No lombok in case we add external methods
}
