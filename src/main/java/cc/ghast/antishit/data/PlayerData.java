package cc.ghast.antishit.data;

import cc.ghast.antishit.api.checks.Check;
import cc.ghast.antishit.managers.CheckManager;
import cc.ghast.antishit.utils.location.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerData {
    /*
        STAFF
    */

    @Getter @Setter private List<Float> yawChangePrevious = new ArrayList<>();
    @Getter @Setter private List<Float> pitchChangePrevious = new ArrayList<>();
    @Getter @Setter private long previousGCD;
    @Getter @Setter private List<Long> previousGCDS = new ArrayList<>();
    @Getter @Setter private boolean debugAim;

    public PlayerData(Player player){
        this.player = player;
        this.uuid = player.getUniqueId();
        this.checkManager = new CheckManager();
        this.movement = new Movement();
        this.staff = new Staff();
        this.general = new General();
    }
    @NonNull
    @Getter private final Player player;
    @Getter private final UUID uuid;
    @Getter private final CheckManager checkManager;
    @Getter private List<Violation> violations = new ArrayList<>();
    @Getter private List<Verbose> verboses = new ArrayList<>();
    public General general;
    public Movement movement;
    public Staff staff;
    public class General {


    }

    public class Movement {
        @Getter @Setter private Position previousPosition;

    }

    public class Staff {
        @Getter @Setter private boolean isVerboseAlertable;
        @Getter @Setter private boolean isVLAlertable;
        @Getter @Setter private boolean isBypassing;
    }

    public void addViolation(Check check){
        if (violations.size() >= 1){
            violations.forEach(item->{
                if (item.getCheck().equals(check)){
                    item.setViolationAmount(item.getViolationAmount() + 1);
                } else {
                    violations.add(new Violation(check, 1));
                }
            });
        } else {
            violations.add(new Violation(check, 1));
        }
    }

    public void addVerbose(Check check){
        if (staff.isBypassing()) return;
        if (verboses.size() >= 1){
            verboses.forEach(item->{
                if (item.getCheck().equals(check)){
                    item.setVerboseAmount(item.getVerboseAmount() + 1);
                } else {
                    verboses.add(new Verbose(check, 1));
                }
            });
        } else {
            verboses.add(new Verbose(check, 1));
        }
    }

    public int getViolations(Check check){
        for (Violation vl : violations){
            if (vl.getCheck().equals(check)){
                return vl.getViolationAmount();
            }
        }
        return 0;
    }
    public int getVerboses(Check check){
        for (Verbose vb : verboses){
            if (vb.getCheck().equals(check)){
                return vb.getVerboseAmount();
            }
        }
        return 0;
    }
}
