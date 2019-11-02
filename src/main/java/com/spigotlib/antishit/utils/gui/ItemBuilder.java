package com.spigotlib.antishit.utils.gui;

import com.spigotlib.antishit.utils.chat.Chat;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItemBuilder {
    private final ItemStack base;
    private ItemMeta baseMeta;

    public ItemBuilder(ItemStack base) {
        this.base = base;
        this.baseMeta = base.getItemMeta();
    }

    public ItemBuilder(MaterialUtils material) {
        this(new ItemStack(material.getMaterial()));
    }

    public ItemBuilder type(Material type) {
        base.setItemMeta(baseMeta);
        base.setType(type);
        baseMeta = base.getItemMeta();
        return this;
    }

    public ItemBuilder data(short data) {
        base.setDurability(data);
        return this;
    }

    public ItemBuilder data(MaterialData data) {
        base.setData(data);
        return this;
    }

    public ItemBuilder amount(int amount) {
        base.setAmount(amount);
        return this;
    }

    public ItemBuilder name(String name) {
        baseMeta.setDisplayName(Chat.translate(name));
        return this;
    }

    public ItemBuilder lore(String... lores) {
        baseMeta.setLore(Stream.of(lores).map(Chat::translate).collect(Collectors.toList()));
        return this;
    }

    public ItemBuilder addLore(String... lores) {
        List<String> lore = Optional.ofNullable(baseMeta.getLore()).orElseGet(ArrayList::new);
        lore.addAll(Stream.of(lores).map(Chat::translate).collect(Collectors.toList()));
        baseMeta.setLore(lore);
        return this;
    }

    public ItemStack build() {
        base.setItemMeta(baseMeta);
        return base.clone();
    }
}
