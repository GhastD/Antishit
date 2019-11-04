package com.spigotlib.antishit.api.check;

import com.spigotlib.antishit.checks.coefficient.TrueYawPitchCoef;
import com.spigotlib.antishit.checks.common.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckManager {

    @Getter private List<AbstractCheck> checks = new ArrayList<>();

    public CheckManager(){
        checks.addAll(Arrays.asList(
                new ClickGCD(),
                new PGCD(),
                new PMagic(),
                new YGCD(),
                new YLCD(),
                new YMagic(),
                new TrueYawPitchCoef()
        ));
    }

    public void disinit(){
        checks.clear();
    }
}
