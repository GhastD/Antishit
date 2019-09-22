package cc.ghast.antishit.commands;

import cc.ghast.antishit.Antishit;
import cc.ghast.antishit.api.checks.Check;
import cc.ghast.antishit.data.PlayerData;
import cc.ghast.antishit.managers.ConfigManager;
import cc.ghast.antishit.utils.chat.Chat;
import cc.ghast.antishit.utils.hastebin.Hastebin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;

import java.util.ArrayList;
import java.util.List;

public class ShitCommand implements CommandExecutor {
    public ShitCommand(){
        Antishit.getInstance().getCommand("shit").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return returnInvalidPlayer(sender);
        Player player = (Player) sender;
        if (!player.hasPermission("shit.debug")) return returnNoPerm(player);
        PlayerData data = Antishit.getInstance().getApi().getPlayerDataManager().getData(player);
        switch (args.length){
            case 1: {
                switch (args[0].toLowerCase()){
                    case "alerts": {
                        data.staff.setVerboseAlertable(true);
                        data.staff.setVLAlertable(true);
                        player.sendMessage(Chat.translate( data.staff.isVerboseAlertable() ? "&7[&c!&7] &6Set alerts on!" : "&7[&c!&7] &6Set alerts off!"));
                        return true;
                    }

                    default: {
                        return returnInfo(player);
                    }
                }
            }
            case 2: {
                switch (args[0].toLowerCase()){
                    case "debug": {
                        switch (args[1].toLowerCase()){
                            case "aim": {
                                data.setDebugAim(!data.isDebugAim());
                                String message = data.isDebugAim() ? "&7[&c!&7] &6Set debug aim on!" : "&7[&c!&7] &6Set debug aim off!";
                                player.sendMessage(Chat.translate(message));
                                return true;
                            }
                            default: {
                                return returnInfo(player);
                            }
                        }
                    }
                    case "paste": {
                        switch (args[1].toLowerCase()){
                            case "gcd": {
                                List<Long> list = data.getPreviousGCDS();
                                String[] payload = new String[list.size()];
                                for (int i = 0; i < list.size(); i++){
                                    payload[i] = list.get(i).toString();
                                }
                                try {
                                    player.sendMessage(Chat.translate("&7[&c!&7] &6Pasted hastebin at: " + Hastebin.paste(payload, "")));
                                } catch (Exception e){
                                    player.sendMessage(Chat.translate("&7[&c!&7] &6Error when pasting to Hastebin. Check console"));
                                }
                                return true;
                            }
                            case "pitchdif": {
                                List<Float> list = data.getPitchChangePrevious();
                                String[] payload = new String[list.size() - 1];
                                for (int i = 0; i < list.size(); i++){
                                    payload[i] = list.get(i).toString();
                                }
                                try {
                                    player.sendMessage(Chat.translate("&7[&c!&7] &6Pasted hastebin at: " + Hastebin.paste(payload, "")));
                                } catch (Exception e){
                                    player.sendMessage(Chat.translate("&7[&c!&7] &6Error when pasting to Hastebin. Check console"));
                                }
                                return true;
                            }
                            case "yawdig": {
                                List<Float> list = data.getYawChangePrevious();
                                String[] payload = new String[list.size() - 1];
                                for (int i = 0; i < list.size(); i++){
                                    payload[i] = list.get(i).toString();
                                }
                                try {
                                    player.sendMessage(Chat.translate("&7[&c!&7] &6Pasted hastebin at: " + Hastebin.paste(payload, "")));
                                } catch (Exception e){
                                    player.sendMessage(Chat.translate("&7[&c!&7] &6Error when pasting to Hastebin. Check console"));
                                }
                                return true;
                            }
                            default: {
                                return returnInfo(player);
                            }
                        }
                    }

                    default: {
                        return returnInfo(player);
                    }
                }
            }

            default: {
                return returnInfo(player);
            }
        }
    }

    private boolean returnInvalidPlayer(CommandSender player){
        player.sendMessage(Chat.translate(ConfigManager.getSettings().getString("message.invalid-player")));
        return false;
    }

    private boolean returnNoPerm(Player player){
        player.sendMessage(Chat.translate(ConfigManager.getSettings().getString("message.no-permission")));
        return false;
    }

    private boolean returnInfo(Player player){
        String[] message = new String[]{
                "&7&m-----------------------------------",
                "&6&lAntishit Debugger &7 made by &6Ghast",
                "&7Version: &6" + Antishit.getInstance().getDescription().getVersion(),
                "&7&m-----------------------------------",
                "&7/&6shit &7-> &6Main shit command",
                "&7/&6shit verbose &7-> &6Toggle verboses",
                "&7/&6shit alerts &7-> &6Toggle alerts",
                "&7/&6shit checks &7-> &6See your current checks",
                "&7/&6shit forcecheck <player> &7-> &6Forcefully start the algorithm",
                "&7&m-----------------------------------"
        };
        for (String s : message){
            player.sendMessage(Chat.translate(s));
        }
        return true;
    }


}
