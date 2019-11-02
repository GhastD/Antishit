package com.spigotlib.antishit.utils.gui.pagination;

import com.spigotlib.antishit.utils.chat.Chat;
import com.spigotlib.antishit.utils.gui.AbstractMenu;
import com.spigotlib.antishit.utils.gui.Button;
import com.spigotlib.antishit.utils.gui.ItemBuilder;
import com.spigotlib.antishit.utils.gui.MaterialUtils;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;
import java.util.WeakHashMap;

public class PaginatedMenu extends AbstractMenu {

    @Getter private final String title;
    private final Button[] buttons, pageButtons;
    private final double maxPages;
    private final Map<Player, Inventory> inventories;
    private final Button glassPane;
    private int page = 1;

    public PaginatedMenu(String title, Button... buttons) {
        this.title = title;
        this.buttons = buttons;
        this.pageButtons = getPageButtons();
        this.inventories = new WeakHashMap<>();
        this.glassPane = new Button(this) {
            ItemStack itemStack = new ItemBuilder(MaterialUtils.GRAY_STAINED_GLASS_PANE).name(" ").build();

            @Override
            public ItemStack getItemStack(Player player) {
                return itemStack;
            }

            @Override
            public void onClick(Player player, ClickType clickType) {
            }

            @Override
            public boolean cancel() {
                return true;
            }
        };

        this.maxPages = Math.ceil(buttons.length / 9.0);
    }

    public void createInventories(Player player) {
        for (int i = 0; i < maxPages; i++) {
            String t = Chat.translate(title).replace("%page%",
                    i + 1 + "").replace("%maxpages%", (int) maxPages + "");

            if(t.length() > 32) t = t.substring(0, 32);

            Inventory inventory = Bukkit.createInventory(null, 27, t);

            /* Glass panes */
            inventory.setItem(18, glassPane.getItemStack(player));
            inventory.setItem(19, glassPane.getItemStack(player));
            inventory.setItem(20, glassPane.getItemStack(player));
            inventory.setItem(24, glassPane.getItemStack(player));
            inventory.setItem(25, glassPane.getItemStack(player));
            inventory.setItem(26, glassPane.getItemStack(player));

            /* Switch page buttons */
            inventory.setItem(21, pageButtons[0].getItemStack(player));
            inventory.setItem(22, pageButtons[1].getItemStack(player));
            inventory.setItem(23, pageButtons[2].getItemStack(player));

            inventories.put(player, inventory);

            try {
                inventory.setItem(0, buttons[(i * 9)].getItemStack(player));
                inventory.setItem(1, buttons[(i * 9) + 1].getItemStack(player));
                inventory.setItem(2, buttons[(i * 9) + 2].getItemStack(player));
                inventory.setItem(3, buttons[(i * 9) + 3].getItemStack(player));
                inventory.setItem(4, buttons[(i * 9) + 4].getItemStack(player));
                inventory.setItem(5, buttons[(i * 9) + 5].getItemStack(player));
                inventory.setItem(6, buttons[(i * 9) + 6].getItemStack(player));
                inventory.setItem(7, buttons[(i * 9) + 7].getItemStack(player));
                inventory.setItem(8, buttons[(i * 9) + 8].getItemStack(player));
            } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    @Override
    public void open(Player player) {
        if(inventories.get(player) == null) createInventories(player);

        player.openInventory(inventories.get(player));
    }

    public void switchPage(boolean forward, Player player) {
        if (forward) {
            if(page == maxPages) page = 1;
            else page++;

            player.closeInventory();
            open(player);
        } else {
            if(page == 1) page = (int) maxPages;
            else page--;

            player.closeInventory();
            open(player);
        }
    }

    public Button[] getPageButtons() {
        Button[] pageButtons = new Button[3];

        pageButtons[0] = new Button(this) {
            ItemStack itemStack = new ItemBuilder(MaterialUtils.ARROW)
                    .name("&6<- Previous Page")
                    .addLore(" ", "&7Click to go to the previous page")
                    .build();

            @Override
            public ItemStack getItemStack(Player player) {
                return itemStack;
            }

            @Override
            public void onClick(Player player, ClickType clickType) {
                switchPage(false, player);
            }

            @Override
            public boolean cancel() {
                return true;
            }
        };

        pageButtons[1] = new Button(this) {
            ItemStack itemStack = new ItemBuilder(MaterialUtils.NAME_TAG)
                    .name("&6&l✲ &cClose Menu &6&l✲")
                    .addLore(" ", "&7Click to close the current menu.")
                    .build();

            @Override
            public ItemStack getItemStack(Player player) {
                return itemStack;
            }

            @Override
            public void onClick(Player player, ClickType clickType) {
                player.closeInventory();
                page = 1;
            }

            @Override
            public boolean cancel() {
                return true;
            }
        };

        pageButtons[2] = new Button(this) {
            ItemStack itemStack = new ItemBuilder(MaterialUtils.ARROW)
                    .name("&6Next Page ->")
                    .addLore(" ", "&7Click to go to the next page")
                    .build();

            @Override
            public ItemStack getItemStack(Player player) {
                return itemStack;
            }

            @Override
            public void onClick(Player player, ClickType clickType) {
                switchPage(true, player);
            }

            @Override
            public boolean cancel() {
                return true;
            }
        };

        return pageButtons;
    }
}
