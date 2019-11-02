package com.spigotlib.antishit.utils.location;

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
    @Getter private final double minX, centerX, maxX;
    @Getter private final double minZ, centerZ, maxZ;

    public Position(Player player, double x, double y, double z, float pitch, float yaw, World bukkitWorld, Location bukkitLocation, long timestamp){
        this.player = player;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.minX = x - 0.3;
        this.centerX = x;
        this.maxX = x + 0.3;
        this.minZ = z - 0.3;
        this.centerZ = z;
        this.maxZ = z + 0.3;
        this.bukkitLocation = bukkitLocation;
        this.bukkitWorld = bukkitWorld;
        this.timestamp = timestamp;
    }

    public Position(Player player, double x, double y, double z, float pitch, float yaw, World bukkitWorld, long timestamp){
        this.player = player;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
        this.minX = x - 0.3;
        this.centerX = x;
        this.maxX = x + 0.3;
        this.minZ = z - 0.3;
        this.centerZ = z;
        this.maxZ = z + 0.3;
        this.bukkitLocation = new Location(bukkitWorld, x, y, z, pitch, yaw);
        this.bukkitWorld = bukkitWorld;
        this.timestamp = timestamp;
    }
    public Position(Player player, World bukkitWorld, Location bukkitLocation, long timestamp){
        this.player = player;
        this.x = bukkitLocation.getX();
        this.y = bukkitLocation.getY();
        this.z = bukkitLocation.getZ();
        this.pitch = bukkitLocation.getPitch();
        this.yaw = bukkitLocation.getYaw();
        this.minX = x - 0.3;
        this.centerX = x;
        this.maxX = x + 0.3;
        this.minZ = z - 0.3;
        this.centerZ = z;
        this.maxZ = z + 0.3;
        this.bukkitLocation = bukkitLocation;
        this.bukkitWorld = bukkitWorld;
        this.timestamp = timestamp;
    }



    public double getDistanceSquared(Position hitbox) {
        double dx = Math.min(Math.abs(hitbox.centerX - minX), Math.abs(hitbox.centerX - maxX));
        double dz = Math.min(Math.abs(hitbox.centerZ - minZ), Math.abs(hitbox.centerZ - maxZ));
        return dx * dx + dz * dz;
    }
}
