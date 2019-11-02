package com.spigotlib.antishit.packet.tinyprotocol.packet.in;

import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.api.ProtocolVersion;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.FieldAccessor;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class WrappedInHeldItemSlotPacket extends NMSObject {
    private static final String packet = Client.HELD_ITEM;

    // Fields
    private static FieldAccessor<Integer> fieldHeldSlot = fetchField(packet, int.class, 0);

    // Decoded data
    private int slot;


    public WrappedInHeldItemSlotPacket(Object packet, Player player) {
        super(packet, player);
    }

    @Override
    public void process(Player player, ProtocolVersion version) {
        slot = fetch(fieldHeldSlot);
    }
}
