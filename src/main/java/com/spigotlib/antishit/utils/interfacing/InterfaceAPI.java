package com.spigotlib.antishit.utils.interfacing;


import com.spigotlib.antishit.Antishit;

public class InterfaceAPI {

    private static InterfaceAPI instance;
    private static InventoryManager invManager;

    public InterfaceAPI(){init();}

    public void init() {
        instance = this;

        invManager = new InventoryManager(Antishit.INSTANCE.getPlugin());
        invManager.init();
    }

    public void disinit() {

    }

    public static InventoryManager manager() { return invManager; }
    public static InterfaceAPI instance() { return instance; }

}
