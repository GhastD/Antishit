package cc.ghast.antishit.api.checks;

import cc.ghast.antishit.Antishit;
import cc.ghast.antishit.api.packet.events.PacketPositionLook;
import cc.ghast.antishit.api.packet.events.PacketUseEntity;
import cc.ghast.antishit.data.PlayerData;
import cc.ghast.antishit.managers.ConfigManager;
import cc.ghast.antishit.utils.chat.Chat;
import cc.ghast.antishit.utils.location.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

@RequiredArgsConstructor
public abstract class Check {
    @Getter private final Antishit antishit = Antishit.getInstance();
    @Getter private final String var;
    @Getter private final CheckType type;
    @Getter private final CheckCategory category;
    @Getter private final int maxVls = 5;
    @Getter private final int maxVbs = 15;

    public void handle(PlayerData data, PlayerMoveEvent event){
        Location to = event.getTo();
        Location from = event.getFrom();
        float yawChange = Math.abs(to.getYaw() - from.getYaw());
        float pitchChange = Math.abs(to.getPitch() - from.getPitch());
        handleRotation(data, yawChange, pitchChange, to, from);
        handleRotation(data, yawChange, pitchChange);
    }
    public void handleRotation(PlayerData data, float yawChange, float pitchChange){
    }
    public void handleRotation(PlayerData data, float yawChange, float pitchChange, Location pos, Location pre){
    }

    public void handle(PlayerData data, PacketUseEntity packetUseEntity) {
    }

    public void handle(PlayerData data, PacketPositionLook packetPositionLook) {
    }

    public void log(PlayerData data, String... args){
        this.runTask(() -> verbose(data, args));
    }

    public void verbose(PlayerData data, String... args) {
        data.addVerbose(this);
        Bukkit.getOnlinePlayers().parallelStream().forEach(player -> {
            PlayerData targetData = antishit.getApi().getPlayerDataManager().getData(player);
            if (player.hasPermission("meme.alert") && targetData.staff.isVerboseAlertable()) {
                String msg = Chat.translate(ConfigManager.getSettings().getString("general.prefix") + " " + ConfigManager.getSettings().getString("message.verbose")
                        .replace("%player%", data.getPlayer().getName())
                        .replace("%check%", type.name())
                        .replace("%violation%", Integer.toString(data.getVerboses(this)))
                        .replace("%type%", var)
                        .replace("%identifiers%", args[0]));
                player.sendMessage(msg);
            }
        });
        if (data.getVerboses(this) >= maxVbs) {
            violate(data, args);
            data.getVerboses().clear();
        }
    }

    public void violate(PlayerData data, String... args) {
        data.addViolation(this);
        Bukkit.getOnlinePlayers().parallelStream().forEach(player -> {
            PlayerData targetData = antishit.getApi().getPlayerDataManager().getData(player);
            if (player.hasPermission("meme.alert") && targetData.staff.isVLAlertable()) {
                String msg = Chat.translate(ConfigManager.getSettings().getString("general.prefix") + " " + ConfigManager.getSettings().getString("message.violation")
                        .replace("%player%", data.getPlayer().getName())
                        .replace("%check%", type.name())
                        .replace("%violation%", Integer.toString(data.getViolations(this)))
                        .replace("%type%", var)
                        .replace("%identifiers%", args[0]));
                player.sendMessage(msg);
            }
        });
    }

    protected void runTask(Runnable runnable) {

        Bukkit.getScheduler().runTask(antishit, runnable);
    }
}
