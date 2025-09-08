package de.neb.x7.client.hacks;

import de.neb.x7.client.hackUtil.Hack;
import net.minecraft.client.MinecraftClient;

public class FlightHack extends Hack {

    private MinecraftClient client = MinecraftClient.getInstance();

    @Override
    public void onDisable() {
        super.onDisable();


    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (client.player == null) return;
        client.player.getAbilities().allowFlying = true;
    }
}
