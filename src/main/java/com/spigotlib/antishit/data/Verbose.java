package com.spigotlib.antishit.data;

import cc.ghast.antishit.api.checks.Check;
import lombok.Getter;
import lombok.Setter;

public class Verbose {
    @Getter private final Check check;
    @Getter @Setter private int verboseAmount;

    public Verbose(Check check, int verboseAmount){
        this.check = check;
        this.verboseAmount = verboseAmount;
    }

}
