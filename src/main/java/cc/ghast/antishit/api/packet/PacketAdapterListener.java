package cc.ghast.antishit.api.packet;

import cc.ghast.antishit.Antishit;
import cc.ghast.antishit.api.packet.events.PacketPositionLook;
import cc.ghast.antishit.api.packet.events.PacketUseEntity;
import cc.ghast.antishit.data.PlayerData;
import cc.ghast.antishit.utils.location.Position;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.google.common.collect.ImmutableList;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class PacketAdapterListener extends PacketAdapter {

    public PacketAdapterListener(Antishit antishit){
        super(antishit,
                PacketType.Play.Client.POSITION_LOOK,
                PacketType.Play.Client.POSITION,
                PacketType.Play.Client.USE_ENTITY,
                PacketType.Play.Client.ARM_ANIMATION,
                PacketType.Play.Client.BLOCK_DIG,
                PacketType.Play.Client.FLYING
        );
    }

    @Override
    public void onPacketReceiving(PacketEvent event){
        Player player = event.getPlayer();
        PlayerData data = Antishit.getInstance().getApi().getPlayerDataManager().getData(player);
        PacketContainer packet = event.getPacket();
        PacketType packetType = event.getPacketType();

        if (player == null) {
            return;
        }


        /*
            Position Look Packet
        */
        if (packetType.equals(PacketType.Play.Client.POSITION_LOOK)){
            Location loc = new Location(player.getWorld(), packet.getDoubles().read(0), packet.getDoubles().read(1),
                    packet.getDoubles().read(2), packet.getFloat().read(0),
                    packet.getFloat().read(1));
            Position position =
                    new Position(player, loc.getX(), loc.getY(), loc.getZ(), loc.getPitch(), loc.getYaw(), player.getWorld(), loc,
                            System.currentTimeMillis());
            /*-----------------------*/
            if (data.movement.getPreviousPosition() != null){
                PacketPositionLook packetPositionLook =
                        new PacketPositionLook(player, position, data.movement.getPreviousPosition(), System.currentTimeMillis());
                data.getCheckManager().getChecks().forEach(check->{
                    check.handle(data, packetPositionLook);
                });
            }
            data.movement.setPreviousPosition(position);
        /*
            Interact Entity Packet
        */
        } else if (packetType.equals(PacketType.Play.Client.USE_ENTITY)) {
            int entityId = packet.getIntegers().read(0);
            EnumWrappers.EntityUseAction action = null;

            try {
                action = packet.getEntityUseActions().read(0);
            } catch (Exception e) {
                // 1.7.10 ProtocolLib Stupidity
            }

            Entity selectedEntity = null;

            ImmutableList<Entity> lockedEntityList
                    = ImmutableList.copyOf(player.getWorld().getEntities());

            for (Entity en : lockedEntityList) {
                if (en.getEntityId() == entityId) {
                    selectedEntity = en;
                }
            }

            if (selectedEntity != null && action != null) {
                PacketUseEntity packetUseEntity = new PacketUseEntity(action, player, selectedEntity, System.currentTimeMillis());
                data.getCheckManager().getChecks().forEach(check->{
                    check.handle(data, packetUseEntity);
                });
            }
        }

    }
}
