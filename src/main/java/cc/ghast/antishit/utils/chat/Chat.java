package cc.ghast.antishit.utils.chat;

import cc.ghast.antishit.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Chat {
    public static String translate(String message){
        String msg = message;
        if (msg.contains("%prefix%")) return ChatColor.translateAlternateColorCodes('&', msg.replace("%prefix%", ConfigManager.getSettings().getString("general.prefix")));
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    public static void sendConsoleMessage(String message){
        Bukkit.getConsoleSender().sendMessage(Chat.translate(message));
    }

    public static void sendConsoleError(String id){
        Bukkit.getConsoleSender().sendMessage(Chat.translate("&aInternal error with Lock Anticheat, please report it to the developer with the following id: " + id));
    }

    public static void notPlayer() {
        Bukkit.getConsoleSender().sendMessage(Chat.translate("&cThis command is for the use of players only!"));
    }
    public static String spacer(){
        return Chat.translate("&8&m----------------------------");
    }

}
