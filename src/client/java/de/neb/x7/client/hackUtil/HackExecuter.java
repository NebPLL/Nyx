package de.neb.x7.client.hackUtil;

import it.unimi.dsi.fastutil.Hash;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.world.tick.WorldTickScheduler;

import java.util.HashMap;

public class HackExecuter {
    private static HashMap<String, Hack> Hacks = Hack.getHacks();

    public static void enableHack(String HackName){
        if (Hacks == null) return;
        Hack.getHack(HackName).onEnable();
        Hack.getHack(HackName).setHackAktive(true);
    }

    public static void disableHack(String HackName){

        if (Hacks == null) return;
        Hack.getHack(HackName).onDisable();
        Hack.getHack(HackName).setHackAktive(false);
    }

    public static void updateHack(String HackName){
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            if (Hacks == null) return;
            if (!Hack.getHack(HackName).getHackState()) return;
            Hack.getHack(HackName).onUpdate();
        });
    }
}
