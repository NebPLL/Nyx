package de.neb.Nyx.client;

import de.neb.Nyx.client.gui.clickGui.MenuKeybinding;
import de.neb.Nyx.client.modules.FlightHack;
import net.minecraft.client.MinecraftClient;

public enum Nyx {
    INSTANCE;

    public static MinecraftClient MC;
    public static final int MainColor = 0xFF00FFFF;

    public void initialize(){

        new FlightHack();

        MC = MinecraftClient.getInstance();

        new MenuKeybinding();

    }
}
