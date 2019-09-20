package cc.ghast.antishit.api.manager;

import cc.ghast.antishit.Antishit;

public abstract class Manager {
    public final Antishit antishit = Antishit.getInstance();

    public abstract void init();
    public abstract void disinit();
}
