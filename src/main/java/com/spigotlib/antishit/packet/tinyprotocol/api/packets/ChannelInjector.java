package com.spigotlib.antishit.packet.tinyprotocol.api.packets;

import com.spigotlib.antishit.packet.tinyprotocol.api.packets.handler.ChannelHandler1_7;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.handler.ChannelHandler1_8;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.handler.ChannelHandlerAbstract;
import com.spigotlib.antishit.packet.tinyprotocol.api.packets.reflection.Reflections;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@Getter
public class ChannelInjector implements Listener {
    private ChannelHandlerAbstract channel;

    public ChannelInjector() {
        this.channel = Reflections.classExists("net.minecraft.util.io.netty.channel.Channel")
                ? new ChannelHandler1_8() : new ChannelHandler1_7();
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinEvent event) {
        this.channel.addChannel(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        this.channel.removeChannel(event.getPlayer());
    }
}
