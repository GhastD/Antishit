package cc.ghast.antishit.utils.gui;


import cc.ghast.antishit.utils.chat.Chat;
import cc.ghast.antishit.utils.chat.StringUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class GUI {

    private Player owner;
    private int size;
    private String displayName;
    private Inventory inventory;

    /**
     * GUI API
     *
     * @param owner - Owner of the inventory, nulling is fine
     * @param displayName - The title of the inventory, seen in top right
     * @param size - The size of the inventory, must be multiples of 9
     */
    public GUI(Player owner, String displayName, int size) {
        this.owner = owner;
        this.size = size;
        this.displayName = displayName;
        this.inventory = Bukkit.createInventory(owner, size, Chat.translate(displayName));
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void displayMenu(Player player) {
        player.openInventory(this.inventory);
    }

    public void setItem(int i, ItemStack itemStack) {
        this.inventory.setItem(i, itemStack);
    }

    public void clearInventory() {
        this.inventory.clear();
    }

    public void setContents(Inventory inv) {
        this.inventory.setContents(inv.getContents());
    }

    public ItemStack[] getContents() {
        return this.inventory.getContents();
    }

    public void setRows(int rows) {
        this.inventory = Bukkit.createInventory(owner, rows * 9, StringUtil.color(displayName));
    }
    public List<Integer> addPanes27(){
        List<Integer> slotsPane = new ArrayList<>();
        slotsPane.add(0);
        slotsPane.add(1);
        slotsPane.add(2);
        slotsPane.add(3);
        slotsPane.add(4);
        slotsPane.add(5);
        slotsPane.add(6);
        slotsPane.add(7);
        slotsPane.add(8);
        slotsPane.add(9);
        slotsPane.add(17);
        slotsPane.add(18);
        slotsPane.add(26);
        slotsPane.add(27);
        slotsPane.add(35);
        slotsPane.add(36);
        slotsPane.add(37);
        slotsPane.add(38);
        slotsPane.add(39);
        slotsPane.add(40);
        slotsPane.add(41);
        slotsPane.add(42);
        slotsPane.add(43);
        slotsPane.add(44);

        return slotsPane;
    }

}
