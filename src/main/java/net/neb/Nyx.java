package net.neb;

import net.neb.event.EventBus;
import net.neb.modules.ModuleList;
import net.neb.util.input.KeyBindingManager;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class Nyx implements ClientModInitializer {

    public static final String MOD_ID = "nyx";
    public static MinecraftClient mc;
    public static EventBus EventBus = new EventBus();
    private final KeyBindingManager keyBindingManager = new KeyBindingManager();
    public static int MainColor = 0xFF000000;


    @Override
    public void onInitializeClient() {

        mc = MinecraftClient.getInstance();

        new ModuleList();

        EventBus.register(keyBindingManager);

    }
}
