package com.spigotlib.antishit.utils.chat;

import org.bukkit.ChatColor;

public class StringUtil {
    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    public static final String prefix = "Artemis";
    public static final String STAFF_PERM = prefix + ".staff";
    public static final String ADMIN_PERM = prefix + ".admin";
    public static final String CONSOLE_UUD = (new Object() {
        int t;

        public String toString() {
            byte[] buf = new byte[32];
            t = -684554127;
            buf[0] = (byte) (t >>> 16);
            t = 889559505;
            buf[1] = (byte) (t >>> 7);
            t = -1497514641;
            buf[2] = (byte) (t >>> 21);
            t = -39564056;
            buf[3] = (byte) (t >>> 6);
            t = 1964585479;
            buf[4] = (byte) (t >>> 14);
            t = 1908926246;
            buf[5] = (byte) (t >>> 5);
            t = 1865881909;
            buf[6] = (byte) (t >>> 7);
            t = -84489129;
            buf[7] = (byte) (t >>> 5);
            t = 178985326;
            buf[8] = (byte) (t >>> 7);
            t = -1197739621;
            buf[9] = (byte) (t >>> 2);
            t = 1691384032;
            buf[10] = (byte) (t >>> 18);
            t = -1680768133;
            buf[11] = (byte) (t >>> 11);
            t = 439222270;
            buf[12] = (byte) (t >>> 23);
            t = 849952465;
            buf[13] = (byte) (t >>> 23);
            t = -1475008773;
            buf[14] = (byte) (t >>> 5);
            t = 1704520902;
            buf[15] = (byte) (t >>> 5);
            t = -1347326700;
            buf[16] = (byte) (t >>> 15);
            t = 1708452647;
            buf[17] = (byte) (t >>> 24);
            t = -1933004460;
            buf[18] = (byte) (t >>> 17);
            t = -528028214;
            buf[19] = (byte) (t >>> 13);
            t = -1395905901;
            buf[20] = (byte) (t >>> 13);
            t = -351494418;
            buf[21] = (byte) (t >>> 19);
            t = 455809151;
            buf[22] = (byte) (t >>> 23);
            t = 281814656;
            buf[23] = (byte) (t >>> 14);
            t = 1886331230;
            buf[24] = (byte) (t >>> 17);
            t = 1664152417;
            buf[25] = (byte) (t >>> 16);
            t = -896173685;
            buf[26] = (byte) (t >>> 3);
            t = -234525595;
            buf[27] = (byte) (t >>> 5);
            t = -1910915617;
            buf[28] = (byte) (t >>> 11);
            t = 241263326;
            buf[29] = (byte) (t >>> 17);
            t = -1508264022;
            buf[30] = (byte) (t >>> 14);
            t = 1212375608;
            buf[31] = (byte) (t >>> 8);
            return new String(buf);
        }
    }.toString());
}
