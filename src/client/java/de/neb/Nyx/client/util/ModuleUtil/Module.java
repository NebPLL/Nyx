package de.neb.Nyx.client.util.ModuleUtil;

import de.neb.Nyx.client.Nyx;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import static de.neb.Nyx.client.Nyx.MC;


public class Module{


    private final String Name = this.getClass().getSimpleName();

    // Hier kann man es dann so machen das man mit json.load(Name, "State") einfach den State kriegt.
    private Boolean HackState =  false;


    public Module(){
        ModuleManager.Modules.add(this);
    }

    public void onEnable() {
        ModuleManager.ActiveModules.add(this);
        HackState = true;
    }

    public void onDisable() {
        ModuleManager.ActiveModules.remove(this);

        HackState = false;

        sendMessage(Text.literal("Test"));
    }

    public void onUpdate(){
        //Arguments füllen
    }

    public void onRender(){
        //Arguments füllen
    }

    public final void isModuleActive(){
        if (HackState) ModuleManager.ActiveModules.add(this);
    }

    public String getName() {
        return Name;
    }

    public Boolean getHackState() {
        // Hier könnte man schauen ob man json.load ... machen will oder schon das geladene HackState machen will
        return HackState;
    }

    public void setHackState(Boolean hackState) {
        // Hier muss es dann auch mit json gespeichert werden
        HackState = hackState;
    }


    public final void sendMessage(Text Message){
        if (MC.player == null) return;
        MC.player.sendMessage(
                Text.literal("[Nyx] ").setStyle(Style.EMPTY.withColor(Nyx.MainColor))
                        .append(Text.literal("[" + Name + "] ").setStyle(Style.EMPTY.withColor(Formatting.BLUE)))
                        .append(Message)

                ,false);

    }
}
