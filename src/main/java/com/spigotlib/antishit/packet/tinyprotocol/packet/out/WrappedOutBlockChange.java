package com.spigotlib.antishit.packet.tinyprotocol.packet.out;

import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.api.Packet;
import com.spigotlib.antishit.packet.tinyprotocol.api.ProtocolVersion;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.FieldAccessor;
import com.spigotlib.antishit.packet.tinyprotocol.packet.types.BaseBlockPosition;
import lombok.Getter;
import org.bukkit.entity.Player;

public class WrappedOutBlockChange extends NMSObject {
    private static final String packet = Packet.Server.BLOCK_CHANGE;

    private static FieldAccessor<Integer> legacyX = fetchField(packet, int.class, 0);
    private static FieldAccessor<Integer> legacyY = fetchField(packet, int.class, 1);
    private static FieldAccessor<Integer> legacyZ = fetchField(packet, int.class, 2);
    private static FieldAccessor<Object> blockPos = fetchField(packet, Object.class, 0);

    @Getter
    private BaseBlockPosition position;

    public WrappedOutBlockChange(Object packet) {
        super(packet);
    }

    @Override
    public void process(Player player, ProtocolVersion version) {
        if (ProtocolVersion.getGameVersion().isBelow(ProtocolVersion.V1_8_5)) {
            position = new BaseBlockPosition(fetch(legacyX), fetch(legacyY), fetch(legacyZ));
        } else {
            position = new BaseBlockPosition(fetch(blockPos));
        }
    }

}
