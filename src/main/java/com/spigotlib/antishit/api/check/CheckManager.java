package com.spigotlib.antishit.api.check;


import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckManager {

    @Getter private List<AbstractCheck> checks = new ArrayList<>();

    public CheckManager(){
        init();
    }

    public void init(){
        checks.addAll(Arrays.asList(

        ));
    }

    public void disinit(){
        checks.clear();
    }
}
