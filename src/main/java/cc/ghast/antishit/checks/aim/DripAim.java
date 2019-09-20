package cc.ghast.antishit.checks.aim;

import cc.ghast.antishit.api.checks.Check;
import cc.ghast.antishit.api.checks.CheckCategory;
import cc.ghast.antishit.api.checks.CheckType;
import cc.ghast.antishit.data.PlayerData;
import cc.ghast.antishit.utils.MathUtil;
import cc.ghast.antishit.utils.chat.Chat;
import cc.ghast.antishit.utils.location.Position;
import org.bukkit.Location;


public class DripAim extends Check {
    public DripAim(){
        super("Drip", CheckType.AIMASSIST, CheckCategory.COMBAT);
    }

    private double multiplier = Math.pow(2, 24);
    private float previous;
    private int vl;
    @Override
    public void handleRotation(PlayerData data, float yawChange, float pitchChange, Location pos, Location pre) {


    }
}
