package com.spigotlib.antishit.utils.smartinvs;


import com.spigotlib.antishit.Antishit;

public class SmartInvsAPI {

    private static SmartInvsAPI instance;
    private static InventoryManager invManager;

    public SmartInvsAPI(){init();}

    public void init() {
        instance = this;

        invManager = new InventoryManager(Antishit.INSTANCE.getPlugin());
        invManager.init();
    }

    public void disinit() {

    }

    public static InventoryManager manager() { return invManager; }
    public static SmartInvsAPI instance() { return instance; }

}
