package com.spigotlib.antishit.packet.tinyprotocol.packet.in;

import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.api.ProtocolVersion;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.FieldAccessor;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class WrappedInFlyingPacket extends NMSObject {
    private static final String packet = Client.FLYING;

    // Fields
    private static FieldAccessor<Double> fieldX = fetchField(packet, double.class, 0);
    private static FieldAccessor<Double> fieldY = fetchField(packet, double.class, 1);
    private static FieldAccessor<Double> fieldZ = fetchField(packet, double.class, 2);
    private static FieldAccessor<Float> fieldYaw = fetchField(packet, float.class, 0);
    private static FieldAccessor<Float> fieldPitch = fetchField(packet, float.class, 1);
    private static FieldAccessor<Boolean> fieldGround = fetchField(packet, boolean.class, 0);

    // Decoded data
    private double x, y, z;
    private float yaw, pitch;
    private boolean look, pos, ground;

    public WrappedInFlyingPacket(Object packet, Player player) {
        super(packet, player);
    }

    @Override
    public void process(Player player, ProtocolVersion version) {
        String name = getPacketName();
        // This saves up 2 reflection calls
        this.pos = name.replace("PacketPlayInFlying", "").replace("$", "").contains("PacketPlayInPosition");
        this.look = name.contains("Look");

        if (pos) {
            this.x = fetch(fieldX);
            this.y = fetch(fieldY);
            this.z = fetch(fieldZ);
        }
        if (look) {
            this.yaw = fetch(fieldYaw);
            this.pitch = fetch(fieldPitch);
        }
        this.ground = fetch(fieldGround);
    }
}
