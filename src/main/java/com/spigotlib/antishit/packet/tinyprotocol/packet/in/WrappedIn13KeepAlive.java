package com.spigotlib.antishit.packet.tinyprotocol.packet.in;

import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.api.ProtocolVersion;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.FieldAccessor;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.Reflection;
import lombok.Getter;
import org.bukkit.entity.Player;

public class WrappedIn13KeepAlive extends NMSObject {
    private static final String packet = Client.KEEP_ALIVE;
    @Getter
    private long ping;
    private FieldAccessor<Long> pingField = Reflection.getFieldSafe(packet, long.class, 0);

    public WrappedIn13KeepAlive(Object object, Player player) {
        super(object, player);
    }

    @Override
    public void process(Player player, ProtocolVersion version) {
        ping = fetch(pingField);
    }
}
