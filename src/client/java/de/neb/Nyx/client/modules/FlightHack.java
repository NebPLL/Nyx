package de.neb.Nyx.client.modules;

import de.neb.Nyx.client.util.ModuleUtil.Module;
import net.minecraft.util.Formatting;

import static de.neb.Nyx.client.util.Nyx.Nyx.MC;

public class FlightHack extends Module {


    public FlightHack() {
        super("Fly Hack");
    }


    @Override
    public void onEnable() {
        super.onEnable();

        sendMessage("Fly hack is now on", Formatting.GREEN);
    }

    @Override
    public void onDisable() {
        super.onDisable();

        sendMessage("Fly hack is now off", Formatting.GREEN);

        if (MC.player == null) return;
        MC.player.getAbilities().allowFlying = false;

    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (MC.player == null) return;
        MC.player.getAbilities().allowFlying = true;
    }
}
