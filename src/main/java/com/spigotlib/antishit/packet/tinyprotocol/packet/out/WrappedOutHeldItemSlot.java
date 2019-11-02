package com.spigotlib.antishit.packet.tinyprotocol.packet.out;

import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.api.ProtocolVersion;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.FieldAccessor;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class WrappedOutHeldItemSlot extends NMSObject {
    private static String packet = Server.HELD_ITEM;
    private FieldAccessor<Integer> slotField = fetchField(packet, int.class, 0);

    private int slot;

    public WrappedOutHeldItemSlot(Object object, Player player) {
        super(object, player);
    }

    public WrappedOutHeldItemSlot(int slot) {
        this.slot = slot;

        setObject(construct(packet, slot));
    }

    @Override
    public void process(Player player, ProtocolVersion version) {
        slot = fetch(slotField);
    }

    @Override
    public Object getObject() {
        return super.getObject();
    }
}
