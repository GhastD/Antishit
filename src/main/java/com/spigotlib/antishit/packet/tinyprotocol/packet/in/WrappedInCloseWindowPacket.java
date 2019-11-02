package com.spigotlib.antishit.packet.tinyprotocol.packet.in;

import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.api.ProtocolVersion;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.FieldAccessor;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class WrappedInCloseWindowPacket extends NMSObject {
    private static final String packet = Client.CLOSE_WINDOW;

    // Fields
    private static FieldAccessor<Integer> fieldId = fetchField(packet, int.class, 0);

    // Decoded data
    private int id;

    public WrappedInCloseWindowPacket(Object packet, Player player) {
        super(packet, player);
    }

    @Override
    public void process(Player player, ProtocolVersion version) {
        id = fetch(fieldId);
    }
}
