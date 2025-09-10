package de.neb.Nyx.client.modules;

import de.neb.Nyx.client.util.ModuleUtil.Module;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import static de.neb.Nyx.client.Nyx.MC;


public class FlightHack extends Module {



    @Override
    public void onEnable() {
        super.onEnable();

        sendMessage(Text.literal("Fly hack is now").setStyle(Style.EMPTY.withColor(Formatting.WHITE))
                .append(Text.literal(" on").setStyle(Style.EMPTY.withColor(Formatting.GREEN))));

        if (MC.player == null) return;
        MC.player.getAbilities().allowFlying = true;
    }

    @Override
    public void onDisable() {
        super.onDisable();

        sendMessage(Text.literal("Fly hack is now").setStyle(Style.EMPTY.withColor(Formatting.WHITE))
                .append(Text.literal(" off").setStyle(Style.EMPTY.withColor(Formatting.RED))));
        if (MC.player == null) return;
        MC.player.getAbilities().allowFlying = false;

    }
}
