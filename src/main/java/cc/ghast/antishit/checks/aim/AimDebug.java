package cc.ghast.antishit.checks.aim;

import cc.ghast.antishit.api.checks.Check;
import cc.ghast.antishit.api.checks.CheckCategory;
import cc.ghast.antishit.api.checks.CheckType;
import cc.ghast.antishit.data.PlayerData;
import cc.ghast.antishit.utils.MathUtil;
import cc.ghast.antishit.utils.chat.Chat;

public class AimDebug extends Check {
    public AimDebug(){
        super("A", CheckType.AIMASSIST, CheckCategory.COMBAT);
    }

    private double multiplier = Math.pow(2, 24);
    private float previous;
    private float previousPitch = 0f;
    private float previousYaw = 0f;

    @Override
    public void handleRotation(PlayerData data, float yawChange, float pitchChange) {
        data.getPitchChangePrevious().add(pitchChange);
        data.getYawChangePrevious().add(yawChange);
        data.getPreviousYawChangeDif().add(Math.abs(previousYaw - yawChange));
        long a = (long) (pitchChange * multiplier);
        long b = (long) (previous * multiplier);

        long gcd = MathUtil.gcd(0x4000, a, b);
        long rawGcd = MathUtil.gcd((int) pitchChange, (int) previousPitch);
        data.getPreviousRawGCDS().add(rawGcd);
        data.setPreviousRawGCD(rawGcd);
        data.setPreviousGCD(gcd);
        data.getPreviousGCDS().add(gcd);
        if (data.isDebugAim()){
            data.getPlayer().sendMessage(Chat.translate("&6Yaw change -> &e" + yawChange + "&6 pitch change -> &e" + pitchChange + "&6 gcd -> &e" + gcd));
        }
        if (data.getYawChangePrevious().size() > 150) data.getYawChangePrevious().clear();
        if (data.getPitchChangePrevious().size() > 150) data.getPitchChangePrevious().clear();
        previousPitch = pitchChange;
        previousYaw = yawChange;
    }
}


