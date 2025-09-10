package de.neb.Nyx.client.util.ModuleUtil;

import de.neb.Nyx.client.util.Nyx.Nyx;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.HashMap;

import static de.neb.Nyx.client.util.Nyx.Nyx.MC;

public class Module{

    private String Name;

    private static final HashMap<String, Module> Modules = new HashMap<>();



    private boolean isHackAktive = false;


    public Module(String Name){
        this.Name = Name;

        Modules.put(Name,this);
    }

    public final void sendMessage(String Message, Formatting color){
        if (MC.player == null) return;
        MC.player.sendMessage(
                Text.literal("[Nyx]").setStyle(Style.EMPTY.withColor(Nyx.MainColor))
                .append(Text.literal("[" + Name + "] ").setStyle(Style.EMPTY.withColor(Formatting.WHITE)))
                .append(Text.literal(Message).setStyle(Style.EMPTY.withColor(color)))

                ,false);

    }

    public void onEnable()  {}

    public void onDisable() {}

    public void onUpdate()  {
        if (!isHackAktive) return;
    }


    public static HashMap<String, Module> getHacks() {
        return Modules;
    }

    public static Module getHack(String HackName){
        return Modules.get(HackName);
    }


    public final String getName() {
        return Name;
    }

    public final void setHackAktive(boolean HackState) {
        isHackAktive = HackState;
    }
    public final boolean getHackState() {
        return isHackAktive;
    }
}
