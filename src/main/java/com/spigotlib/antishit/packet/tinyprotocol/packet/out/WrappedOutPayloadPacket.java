package com.spigotlib.antishit.packet.tinyprotocol.packet.out;

import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.api.ProtocolVersion;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.FieldAccessor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.entity.Player;

@Getter
@NoArgsConstructor
public class WrappedOutPayloadPacket extends NMSObject {
    private static final String packet = Server.CUSTOM_PAYLOAD;

    // Fields
    private static FieldAccessor<String> fieldTag = fetchField(packet, String.class, 0);
    private static FieldAccessor<byte[]> fieldData = fetchField(packet, byte[].class, 1);

    // Decoded data
    private String tag;
    private byte[] data;

    public WrappedOutPayloadPacket(Object packet, Player player) {
        super(packet, player);
    }

    @Override
    public void process(Player player, ProtocolVersion version) {
        tag = fetch(fieldTag);
        data = fetch(fieldData);
    }
}
