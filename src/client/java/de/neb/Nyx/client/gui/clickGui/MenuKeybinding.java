package de.neb.Nyx.client.gui.clickGui;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class MenuKeybinding {

    private static KeyBinding MenuKeyBinding;

    public MenuKeybinding(){
        MenuKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Open Hack menu", // The translation key of the keybinding's name
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT, // The keycode of the key
                "0x7" // The translation key of the keybinding's category.
        ));

        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            if (MenuKeyBinding.isPressed()){
                client.setScreen(new HackMenu());
            }
        });
    }
}
