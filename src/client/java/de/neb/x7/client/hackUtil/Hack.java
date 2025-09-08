package de.neb.x7.client.hackUtil;

import java.util.HashMap;

public class Hack{

    private String Name = this.getClass().getSimpleName();

    private static final HashMap<String, Hack> Hacks = new HashMap<>();

    private boolean isHackAktive = false;


    public Hack(){
        Hacks.put(Name,this);
    }

    public void onEnable()  {}

    public void onDisable() {}

    public void onUpdate()  {
        if (!isHackAktive) return;
    }


    public static HashMap<String, Hack> getHacks() {
        return Hacks;
    }

    public static Hack getHack(String HackName){
        return Hacks.get(HackName);
    }


    public final String getNameHack() {
        return Name;
    }

    public final void setHackAktive(boolean HackState) {
        isHackAktive = HackState;
    }
    public final boolean getHackState() {
        return isHackAktive;
    }
}
