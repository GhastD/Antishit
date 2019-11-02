package com.spigotlib.antishit.data;

import cc.ghast.antishit.api.checks.Check;
import lombok.Getter;
import lombok.Setter;

public class Violation {
    @Getter private final Check check;
    @Getter @Setter private int violationAmount;

    public Violation(Check check, int violationAmount){
        this.check = check;
        this.violationAmount = violationAmount;
    }
}
