package de.neb.util.misc.input;


import de.neb.event.EventHandler;
import de.neb.event.events.TickEvent;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.font.FontManager;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
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
            System.out.println("Test");
        }
    }
}
