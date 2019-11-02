package com.spigotlib.antishit.checks.common;

import com.spigotlib.antishit.api.check.AbstractCheck;
import com.spigotlib.antishit.api.check.Check;
import com.spigotlib.antishit.data.PlayerData;
import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.packet.in.WrappedInArmAnimationPacket;
import com.spigotlib.antishit.packet.tinyprotocol.packet.in.WrappedInFlyingPacket;
import com.spigotlib.antishit.utils.location.Position;

/**
 * @author Ghast
 * @since 02-Nov-19
 * Ghast CC © 2019
 */
@Check(name = "ClickGCD", id="click::gcd")
public class ClickGCD extends AbstractCheck {

    private long last;
    private double multiplier = Math.pow(2, 24);

    @Override
    public void handle(PlayerData data, NMSObject packet){
        if (packet instanceof WrappedInArmAnimationPacket){
            long current = System.currentTimeMillis();
            if (last != 0){
                long gcd = gcd(current, last);
                log(gcd);
            }
            last = current;
        }
    }

    private long gcd(long a, long b) {
        if (b <= 0x4000) {
            return a;
        }
        return gcd(b, a % b);
    }
}
