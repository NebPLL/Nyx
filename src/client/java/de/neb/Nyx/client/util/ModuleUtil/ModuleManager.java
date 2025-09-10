package de.neb.Nyx.client.util.ModuleUtil;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.util.HashMap;

public class ModuleManager {
    private static HashMap<String, Module > Modules = Module.getHacks();


    public static void loadHacks(){
        // TODO: Load hacks.
    }

    public static void enableHack(String HackName){
        if (Modules == null) return;

        Module hack = Module.getHack(HackName);

        if (hack == null) return;

        hack.onEnable();
        hack.setHackAktive(true);
    }

    public static void disableHack(String HackName){

        if (Modules == null) return;

        Module hack = Module.getHack(HackName);
        if (hack == null) return;

        hack.onDisable();
        hack.setHackAktive(false);
    }

    public static void updateHack(String HackName){
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            if (Modules == null) return;

            Module hack = Module.getHack(HackName);
            if (hack == null) return;
            if (!hack.getHackState()) return;

            hack.onUpdate();
        });
    }
}
