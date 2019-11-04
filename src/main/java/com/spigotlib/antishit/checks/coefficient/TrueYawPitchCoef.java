package com.spigotlib.antishit.checks.coefficient;

import com.google.common.collect.EvictingQueue;
import com.google.common.collect.ForwardingDeque;
import com.google.common.collect.ForwardingQueue;
import com.spigotlib.antishit.api.check.AbstractCheck;
import com.spigotlib.antishit.api.check.Check;
import com.spigotlib.antishit.data.PlayerData;
import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.packet.in.WrappedInFlyingPacket;
import com.spigotlib.antishit.utils.MathUtil;

import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * @author Ghast
 * @since 02-Nov-19
 * Ghast CC © 2019
 */

@Check(name="True Y/P Coef", id="yp::coef::true")
public class TrueYawPitchCoef extends AbstractCheck {

    private float previousY = 0f;
    private float previousP = 0f;
    private float previousCoef = 0f;
    private double previousCoefDelta = 0f;
    private double multiplier = Math.pow(2, 24);
    private ForwardingQueue<Double> deltas = EvictingQueue.create(8);

    @Override
    public void handle(PlayerData data, NMSObject packet) {
        if (packet instanceof WrappedInFlyingPacket && ((WrappedInFlyingPacket) packet).isLook()){
            float yaw = ((WrappedInFlyingPacket) packet).getYaw();
            float trueyaw = ((yaw) > 180f) ? (yaw - 360f) : yaw;
            float pitch = ((WrappedInFlyingPacket) packet).getPitch();
            if (previousP != 0f || previousY != 0f){
                float coef = Math.abs(trueyaw / pitch);
                if (previousCoef != 0f){
                    double coefDelta = (Math.abs(coef - previousCoef) * multiplier);
                    deltas.add(coefDelta);

                    if (deltas.size() > 7){
                        double gcd = MathUtil.findGCD(getLongs(deltas), deltas.size());
                        log(gcd);
                    }
                    if (previousCoefDelta != 0){
                        double gcd = MathUtil.gcd((long) coefDelta, (long)previousCoefDelta);
                    }
                    previousCoefDelta = coefDelta;
                }
                //log(coef);
                previousCoef = coef;
            }

            previousP = pitch;
            previousY = trueyaw;
        }
    }

    private double[] getLongs(Queue<Double> value){
        double[] returnValue = new double[value.size()];
        for (int i = 0; i < value.size(); i++){
            double va = value.poll();
            returnValue[i] = va;
        }
        return returnValue;
    }
}
