package com.spigotlib.antishit.packet.tinyprotocol.packet.in;

import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.api.ProtocolVersion;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.FieldAccessor;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class WrappedInCustomPayload extends NMSObject {

    private static final String packet = Client.CUSTOM_PAYLOAD;

    public WrappedInCustomPayload(Object object, Player player) {
        super(object, player);
    }

    private static FieldAccessor<String> messageAccessor = fetchField(packet, String.class, 0);

    private String message;

    @Override
    public void process(Player player, ProtocolVersion version) {
        message = fetch(messageAccessor);
    }
}
