package cc.ghast.antishit.utils.gui;

import cc.ghast.antishit.utils.chat.Chat;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    public static ItemStack buildItem(Material material, String displayName, int amount,
                                      byte data, String... lore) {
        ItemStack itemStack = new ItemStack(material, amount, data);
        ItemMeta itemMeta = itemStack.getItemMeta();

        if (!displayName.equals("")) {
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                    displayName));
        }

        List<String> loreList = new ArrayList<>();

        for (String s : lore) {
            loreList.add(Chat.translate(s));
        }

        itemMeta.setLore(loreList);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
    public static ItemStack buildItem(Material material, String displayName, int amount,
                                      byte data, List<String> list) {
        ItemStack itemStack = new ItemStack(material, amount, data);
        ItemMeta itemMeta = itemStack.getItemMeta();

        if (!displayName.equals("")) {
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                    displayName));
        }

        List<String> loreList = new ArrayList<>();

        for (String s : list) {
            loreList.add(Chat.translate(s));
        }

        itemMeta.setLore(loreList);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

        public static ItemStack buildItem(Material material, String displayName, int amount,
                                      String... lore) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();

        if (!displayName.equals("")) {
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                    displayName));
        }

        List<String> loreList = new ArrayList<>();

        for (String s : lore) {
            loreList.add(Chat.translate(s));
        }

        itemMeta.setLore(loreList);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack buildItem(Material material, String displayName, String... lore) {
        return buildItem(material, displayName, 1, (byte)0, lore);
    }

    public static ItemStack buildItem(Material material) {
        return buildItem(material, "", 1, (byte) 0);
    }

    public static ItemStack buildItem(Material material, String displayName) {
        return buildItem(material, displayName, 1, (byte) 0);
    }

    public static ItemStack buildItem(Material material, String displayName, byte data) {
        return buildItem(material, displayName, 1, data);
    }

    public static ItemStack buildItem(Material material, String displayName, int amount) {
        return buildItem(material, displayName, amount, (byte) 0);
    }

    public static ItemStack buildItem(Material material, int amount) {
        return buildItem(material, "", amount, (byte) 0);
    }

    public static ItemStack buildItem(Material material, byte data) {
        return buildItem(material, "", 1, data);
    }

    public static ItemStack buildItem(Material material, int amount, String displayName) {
        return buildItem(material, displayName, amount, (byte) 0);
    }
}
