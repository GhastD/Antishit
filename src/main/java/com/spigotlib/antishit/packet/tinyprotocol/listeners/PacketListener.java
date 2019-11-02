package com.spigotlib.antishit.packet.tinyprotocol.listeners;

import com.spigotlib.antishit.Antishit;
import com.spigotlib.antishit.data.PlayerData;
import com.spigotlib.antishit.packet.PacketUtil;
import com.spigotlib.antishit.packet.event.PacketReceiveEvent;
import com.spigotlib.antishit.packet.event.PacketSendEvent;
import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import org.bukkit.entity.Player;

/**
 * @author Ghast
 * @since 11-Oct-19
 * Ghast CC © 2019
 */
public class PacketListener {

    public void onPacket(PacketReceiveEvent event){
        try {
            Player player = event.getPlayer();
            PlayerData data = Antishit.INSTANCE.getApi().getPlayerDataManager().getData(player);
            if (player == null || data == null || event.getPacket() == null) return;
            Object packet = event.getPacket();
            long now = System.currentTimeMillis();
            // Packet Position
            NMSObject payload = PacketUtil.findInboundPacket(player, event.getType(), event.getPacket());
            data.getCheckManager().getChecks().forEach(check -> check.handle(data, payload));
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void onSend(PacketSendEvent e){
        Player player = e.getPlayer();
        PlayerData data = Antishit.INSTANCE.getApi().getPlayerDataManager().getData(player);
        Object packet = e.getPacket();
        if (player == null || data == null || e.getPacket() == null) return;

    }

}
