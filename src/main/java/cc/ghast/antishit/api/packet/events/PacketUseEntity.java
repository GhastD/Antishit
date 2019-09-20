package cc.ghast.antishit.api.packet.events;


import com.comphenix.protocol.wrappers.EnumWrappers;
import lombok.Getter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class PacketUseEntity {
    @Getter private final Player attacker;
    @Getter private final Entity attacked;
    @Getter private final long timestamp;
    @Getter private final EnumWrappers.EntityUseAction entityUseAction;

    public PacketUseEntity(EnumWrappers.EntityUseAction entityUseAction, Player attacker, Entity attacked, long timestamp){
        this.entityUseAction = entityUseAction;
        this.attacker = attacker;
        this.attacked = attacked;
        this.timestamp = timestamp;
    }
}
