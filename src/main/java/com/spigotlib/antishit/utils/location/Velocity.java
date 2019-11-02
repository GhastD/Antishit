package com.spigotlib.antishit.utils.location;

import lombok.Getter;

/**
 * @author Ghast
 * @since 28-Oct-19
 * Ghast CC © 2019
 */

@Getter
public class Velocity {
    private double x;
    private double y;
    private double z;
    private double horizontal, vertical;
    
    public Velocity(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.horizontal = Math.sqrt(x * x + z * z);
        this.vertical = Math.abs(y);
    }
}
