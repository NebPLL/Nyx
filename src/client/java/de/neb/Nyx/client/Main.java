package de.neb.Nyx.client;

import de.neb.Nyx.client.gui.clickGui.MenuKeybinding;
import de.neb.Nyx.client.modules.FlightHack;
import de.neb.Nyx.client.util.ModuleUtil.ModuleManager;
import net.fabricmc.api.ClientModInitializer;

public class Main implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        new MenuKeybinding();

        new FlightHack();

        ModuleManager.loadHacks();

        ModuleManager.enableHack("FlightHack");

        ModuleManager.updateHack("FlightHack");


    }
}
