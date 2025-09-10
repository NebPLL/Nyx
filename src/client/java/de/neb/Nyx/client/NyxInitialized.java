package de.neb.Nyx.client;

import de.neb.Nyx.client.gui.clickGui.MenuKeybinding;
import de.neb.Nyx.client.modules.FlightHack;
import de.neb.Nyx.client.util.ModuleUtil.ModuleManager;
import net.fabricmc.api.ClientModInitializer;

public class NyxInitialized implements ClientModInitializer {

    private boolean Initialized;

    @Override
    public void onInitializeClient() {

        if(Initialized)
            throw new RuntimeException(
                    "Nyx ran twice!");

        Nyx.INSTANCE.initialize();

        Initialized = true;


    }
}
