package com.spigotlib.antishit.utils.gui.listener;

import com.spigotlib.antishit.utils.gui.Button;
import com.spigotlib.antishit.Antishit;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ButtonListener implements Listener {

    public ButtonListener(){
        Bukkit.getPluginManager().registerEvents(this, Antishit.INSTANCE.getPlugin());
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(event.getCurrentItem() == null) return;

        Button button = Button.buttons.parallelStream().filter(b -> b.getItemStack((Player) event.getWhoClicked()).isSimilar(event.getCurrentItem()))
                .findFirst().orElse(null);

        if (button == null) return;

        if(button.cancel()) event.setCancelled(true);

        button.onClick((Player) event.getWhoClicked(), event.getClick());
    }
}
