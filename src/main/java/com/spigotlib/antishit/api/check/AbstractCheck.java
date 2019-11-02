package com.spigotlib.antishit.api.check;

import com.spigotlib.antishit.data.PlayerData;
import com.spigotlib.antishit.packet.tinyprotocol.api.NMSObject;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ghast
 * @since 02-Nov-19
 * Ghast CC © 2019
 */

@Getter
public class AbstractCheck {

    private String name = this.getClass().getAnnotation(Check.class).name();
    private String id = this.getClass().getAnnotation(Check.class).id();

    private List<Double> log = new ArrayList<>();

    public void handle(PlayerData data, NMSObject payload){ }

    public void log(double value){
        log.add(value);
        Bukkit.getOnlinePlayers().forEach(player -> {

        });
    }

    public double[] arrayReturn(){
        double[] returnValue = new double[log.size()];
        for (int i = 0; i < log.size(); i++){
            returnValue[i] = log.get(i);
        }
        return returnValue;
    }

    public String[] arrayReturnString(){
        if (log.size() > 0){
            String[] returnValue = new String[log.size()];
            for (int i = 0; i < log.size(); i++){
                returnValue[i] = log.get(i).toString();
            }
            return returnValue;
        }
        return null;
    }
}
