package de.neb.Nyx.client.gui.clickGui;

import de.neb.Nyx.client.util.ModuleUtil.ModuleManager;
import de.neb.Nyx.client.util.Nyx.Nyx;
import de.neb.Nyx.client.util.ModuleUtil.Module;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class HackMenu extends Screen {

    private boolean mouseClicked = false;
    private double mouseX, mouseY;
    private int buttonActive = 0xFF00FF00;

    protected HackMenu() {
        super(Text.of("0x7 Hack Menu"));
    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);
        Button(context,10,10,100,100, Module.getHack("FlightHack"));
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseY = mouseY;
        this.mouseX = mouseX;

        if(button == GLFW.GLFW_MOUSE_BUTTON_1){
            mouseClicked = true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if(button == GLFW.GLFW_MOUSE_BUTTON_1){
            mouseClicked = false;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    public void Button(DrawContext context, int x, int y, int width, int height, Module module){

        context.drawBorder(x, y, x + width, y + height, Nyx.MainColor);

        boolean hackState = module.getHackState();
        if (hackState)
            context.drawBorder(x, y, x + width, y + height, buttonActive);

        if(mouseClicked){
            if (mouseX > x && mouseY > y && mouseX < x+width && mouseY < y + height ){

                if (hackState){
                    System.out.println("Hack Disabled");
                    ModuleManager.disableHack(module.getName());
                }else {
                    System.out.println("Hack Enabled");
                    ModuleManager.enableHack(module.getName());
                }
            }

            mouseClicked = false;
        }

    }
}
