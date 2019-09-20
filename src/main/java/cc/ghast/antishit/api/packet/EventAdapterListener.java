package cc.ghast.antishit.api.packet;

import cc.ghast.antishit.Antishit;
import cc.ghast.antishit.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventAdapterListener implements Listener {
    public EventAdapterListener(Antishit antishit){
        Bukkit.getPluginManager().registerEvents(this, antishit);
    }

    @EventHandler
    public void onEvent(PlayerMoveEvent event){
        PlayerData data = Antishit.getInstance().getApi().getPlayerDataManager().getData(event.getPlayer());
        data.getCheckManager().getChecks().forEach(check->check.handle(data, event));
    }
}
