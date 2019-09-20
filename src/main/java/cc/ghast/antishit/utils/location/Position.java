package cc.ghast.antishit.utils.location;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Position {

    @Getter private final Player player;
    @Getter private final double x;
    @Getter private final double y;
    @Getter private final double z;
    @Getter private final float pitch;
    @Getter private final float yaw;
    @Getter private final World bukkitWorld;
    @Getter private final Location bukkitLocation;
    @Getter private final long timestamp;

    public Position(Player player, double x, double y, double z, float pitch, float yaw, World bukkitWorld, Location bukkitLocation, long timestamp){
        this.player = player;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.bukkitLocation = bukkitLocation;
        this.bukkitWorld = bukkitWorld;
        this.timestamp = timestamp;
    }
}
