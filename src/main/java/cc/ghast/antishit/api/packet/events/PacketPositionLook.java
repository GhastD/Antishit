package cc.ghast.antishit.api.packet.events;

import cc.ghast.antishit.utils.location.Position;
import lombok.Getter;
import org.bukkit.entity.Player;

public class PacketPositionLook {

    @Getter private Player player;
    @Getter private Position to;
    @Getter private Position from;
    @Getter private long timestamp;

    public PacketPositionLook(Player player, Position to, Position from, Long timestamp){
        this.player = player;
        this.to = to;
        this.from = from;
        this.timestamp = timestamp;
    }
}
