package com.spigotlib.antishit.packet;

import com.spigotlib.antishit.Antishit;
import com.spigotlib.antishit.packet.event.PacketReceiveEvent;
import com.spigotlib.antishit.packet.event.PacketSendEvent;
import com.spigotlib.antishit.packet.tinyprotocol.api.Packet;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.ChannelInjector;
import com.spigotlib.antishit.packet.tinyprotocol.listeners.PacketListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TinyProtocolHandler {

    @Getter
    private static ChannelInjector instance;
    @Getter private PacketListener packetListener;
    @Getter private static JavaPlugin plugin;
    public TinyProtocolHandler(JavaPlugin javaPlugin) {
        init(javaPlugin);
    }

    public synchronized void init(JavaPlugin javaPlugin){
        plugin = javaPlugin;
        instance = new ChannelInjector();
        packetListener = new PacketListener();
        Bukkit.getPluginManager().registerEvents(instance, javaPlugin);
    }

    public static Object onPacketOutAsync(Player sender, Object packet) {
        String name = packet.getClass().getName();
        int index = name.lastIndexOf(".");
        String packetName = name.substring(index + 1).replace("PacketPlayInUseItem", "PacketPlayInBlockPlace")
                .replace(Packet.Client.LEGACY_LOOK, Packet.Client.LOOK)
                .replace(Packet.Client.LEGACY_POSITION, Packet.Client.POSITION)
                .replace(Packet.Client.LEGACY_POSITION_LOOK, Packet.Client.POSITION_LOOK);

        PacketReceiveEvent event = new PacketReceiveEvent(sender, packet, packetName);
        Antishit.INSTANCE.getApi().getTinyProtocolHandler().getPacketListener().onPacket(event);
        Bukkit.getPluginManager().callEvent(event);

        return !event.isCancelled() ? event.getPacket() : null;
    }

    public static Object onPacketInAsync(Player sender, Object packet) {
        String name = packet.getClass().getName();
        int index = name.lastIndexOf(".");
        String packetName = name.substring(index + 1);


        PacketSendEvent event = new PacketSendEvent(sender, packet, packetName);
        if (!event.isCancelled()) Antishit.INSTANCE.getApi().getTinyProtocolHandler().getPacketListener().onSend(event);
        Bukkit.getPluginManager().callEvent(event);

        return !event.isCancelled() ? event.getPacket() : null;
    }
}

