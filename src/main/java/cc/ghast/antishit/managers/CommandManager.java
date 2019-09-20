package cc.ghast.antishit.managers;


import cc.ghast.antishit.api.manager.Manager;
import cc.ghast.antishit.commands.ShitCommand;

public class CommandManager extends Manager {

    public void init(){
        new ShitCommand();
    }

    public void disinit(){

    }
}
