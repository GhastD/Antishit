package com.spigotlib.antishit.data;


import com.spigotlib.antishit.api.check.AbstractCheck;
import com.spigotlib.antishit.api.check.CheckManager;
import com.spigotlib.antishit.utils.location.Position;
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
    @Getter @Setter private long previousRawGCD;
    @Getter @Setter private List<Long> previousGCDS = new ArrayList<>();
    @Getter @Setter private List<Long> previousRawGCDS = new ArrayList<>();
    @Getter @Setter private List<Float> previousYawChangeDif = new ArrayList<>();
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
}
