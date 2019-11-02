package com.spigotlib.antishit.packet.tinyprotocol.packet.out;

import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import com.spigotlib.antishit.packet.tinyprotocol.api.ProtocolVersion;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.FieldAccessor;
import com.spigotlib.antishit.packet.tinyprotocol.packet.types.WrappedChatMessage;
import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class WrappedOutOpenWindow extends NMSObject {

    private static String packet = Server.OPEN_WINDOW;

    public WrappedOutOpenWindow(Object object, Player player) {
        super(object, player);
    }

    public WrappedOutOpenWindow(int id, String name, WrappedChatMessage msg, int size) {
        setPacket(packet, id, name, msg.getObject(), size);
    }

    private static FieldAccessor<Integer> idField = fetchField(packet, int.class, 0);
    private static FieldAccessor<String> nameField = fetchField(packet, String.class, 0);
    private static FieldAccessor<Object> chatCompField = fetchField(packet, Object.class, 2);
    private static FieldAccessor<Integer> inventorySize = fetchField(packet, int.class, 1);

    private int id;
    private String name;
    private WrappedChatMessage chatComponent;
    private int size;

    @Override
    public void process(Player player, ProtocolVersion version) {
        id = fetch(idField);
        name = fetch(nameField);
        chatComponent = new WrappedChatMessage(fetch(chatCompField));
        size = fetch(inventorySize);
    }
}
