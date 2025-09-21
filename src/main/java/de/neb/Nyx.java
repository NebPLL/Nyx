package de.neb;

import de.neb.event.EventBus;
import de.neb.util.misc.input.KeyBindingManager;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;

public class Nyx implements ClientModInitializer {

    public static final String MOD_ID = "nyx";
    public static MinecraftClient mc;
    public static EventBus EventBus = new EventBus();
    private final KeyBindingManager keyBindingManager = new KeyBindingManager();

    @Override
    public void onInitializeClient() {

        EventBus.register(keyBindingManager);

    }
}
