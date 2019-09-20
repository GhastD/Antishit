package cc.ghast.antishit.api.packet.events;

import cc.ghast.antishit.utils.location.Position;
import lombok.Getter;
import org.bukkit.entity.Player;

public class PacketPosition {
    @Getter private Player player;
    @Getter private Position to;
    @Getter private Position from;
    @Getter private long timestamp;
}
