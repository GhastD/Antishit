package com.spigotlib.antishit.checks.common;

import com.spigotlib.antishit.api.check.AbstractCheck;
import com.spigotlib.antishit.api.check.Check;
import com.spigotlib.antishit.data.PlayerData;
import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.packet.in.WrappedInFlyingPacket;
import com.spigotlib.antishit.utils.location.Position;

/**
 * @author Ghast
 * @since 02-Nov-19
 * Ghast CC © 2019
 */
@Check(name = "Y-Magic", id="yaw::magic")
public class YMagic extends AbstractCheck {

    private Position lastPos;
    private double multiplier = Math.pow(2, 24);

    @Override
    public void handle(PlayerData data, NMSObject packet){
        if (packet instanceof WrappedInFlyingPacket){
            Position current = new Position(packet.getPlayer(),
                    ((WrappedInFlyingPacket) packet).getX(),
                    ((WrappedInFlyingPacket) packet).getY(),
                    ((WrappedInFlyingPacket) packet).getZ(),
                    ((WrappedInFlyingPacket) packet).getPitch(),
                    ((WrappedInFlyingPacket) packet).getYaw(),
                    packet.getPlayer().getWorld(),
                    System.currentTimeMillis()
                    );

            if (lastPos != null){
                float magicVal = current.getYaw() * 100 / lastPos.getYaw();
                log(magicVal);
            }
            lastPos = current;
        }
    }
}
