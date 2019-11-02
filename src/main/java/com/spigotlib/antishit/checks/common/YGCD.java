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
@Check(name = "YGCD", id="yaw::gcd")
public class YGCD extends AbstractCheck {

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
                long a = (long) (current.getYaw() * multiplier);
                long b = (long) (lastPos.getYaw() * multiplier);

                long gcd = gcd(a, b);

                log(gcd);
            }

            lastPos = current;
        }
    }

    private long gcd(long a, long b) {
        if (b <= 0x4000) {
            return a;
        }
        return gcd(b, a % b);
    }
}
