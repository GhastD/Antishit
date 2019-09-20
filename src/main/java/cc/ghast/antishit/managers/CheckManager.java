package cc.ghast.antishit.managers;


import cc.ghast.antishit.api.checks.Check;
import cc.ghast.antishit.api.manager.Manager;
import cc.ghast.antishit.checks.aim.AimDebug;
import cc.ghast.antishit.checks.aim.DripAim;
import lombok.Getter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckManager extends Manager {

    @Getter private List<Check> checks = new ArrayList<>();

    public CheckManager(){
        init();
    }

    public void init(){
        checks.addAll(Arrays.asList(
                new AimDebug(),
                new DripAim()
        ));
    }

    public void disinit(){
        checks.clear();
    }
}
