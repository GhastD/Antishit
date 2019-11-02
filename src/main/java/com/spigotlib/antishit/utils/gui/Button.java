package com.spigotlib.antishit.utils.gui;

import com.sun.istack.internal.Nullable;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import java.util.HashSet;
import java.util.Set;

public abstract class Button {

    public static Set<Button> buttons;

    private AbstractMenu menu;

    static {
        buttons = new HashSet<>();
    }

    public Button(@Nullable AbstractMenu menu) {
        this.menu = menu;

        buttons.add(this);
    }

    public abstract ItemStack getItemStack(Player player);
    public abstract void onClick(Player player, ClickType clickType);
    public abstract boolean cancel();

    public AbstractMenu getMenu() {
        return menu;
    }
}
