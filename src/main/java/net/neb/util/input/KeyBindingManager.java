package net.neb.util.input;


import net.neb.Nyx;
import net.neb.event.EventHandler;
import net.neb.event.world.TickEvent;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.neb.gui.ClickGui;
import net.neb.gui.ModuleScreen;
import org.lwjgl.glfw.GLFW;

public class KeyBindingManager {

    private static KeyBinding OPEN_GUI;

    public KeyBindingManager(){
        OPEN_GUI = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.examplemod.spook",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "Nyx"
        ));
    }

    @EventHandler
    public void tick(TickEvent.Pre event){
        if(OPEN_GUI.isPressed()){
            Nyx.mc.setScreen(new ClickGui());
        }
    }
}
