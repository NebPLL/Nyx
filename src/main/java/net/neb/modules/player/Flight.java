package net.neb.modules.player;

import net.neb.event.EventHandler;
import net.neb.event.world.TickEvent;
import net.neb.modules.Category;
import net.neb.modules.Categorys;
import net.neb.modules.Module;

public class Flight extends Module {
    public Flight() {
        super("Flight", Categorys.player, "This hack lets you Fly.");
    }

    @Override
    public void onEnable() {
        super.onEnable();

        System.out.println("ON");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        System.out.println("Off");
    }


    @EventHandler
    public void onUpdate(TickEvent.Pre event){
        System.out.println("Update");
    }

}
