package cc.ghast.antishit.managers;



import cc.ghast.antishit.api.manager.Manager;
import cc.ghast.antishit.api.packet.EventAdapterListener;
import cc.ghast.antishit.api.packet.PacketAdapterListener;
import com.comphenix.protocol.ProtocolLibrary;
import lombok.Getter;

public class ProtocolManager extends Manager {
    @Getter private EventAdapterListener eventAdapterListener;
    public ProtocolManager(){

    }

    public void init(){
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapterListener(antishit));
        eventAdapterListener = new EventAdapterListener(antishit);
    }

    public void disinit(){

    }
}
