package net.neb.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.neb.Nyx;
import net.neb.modules.Categorys;
import net.neb.modules.Module;
import org.lwjgl.glfw.GLFW;

public class ModuleScreen extends Screen {

    private boolean mouseLeftClicked = false;
    private boolean mouseRightClicked = false;
    private double mouseX, mouseY;
    private int buttonActive = 0xFF00FF00;




    public ModuleScreen() {
        super(Text.of("0x7 Hack Menu"));
    }


    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);

        int buttonsPerRow = 4;
        int buttonCount = net.neb.modules.Module.modules.size();
        int buttonWidth = 80;
        int buttonHeight = 30;
        int spacingRight = 10;
        int spacingDown = 10;
        int startY = 20;

        int totalRowWidth = buttonsPerRow * buttonWidth + (buttonsPerRow - 1) * spacingRight;

        int startX = (this.width - totalRowWidth) / 2;



        for (int i = 0; i < buttonCount; i++) {
            int row = i / buttonsPerRow;
            int col = i % buttonsPerRow;

            int x = startX + col * (buttonWidth + spacingRight);
            int y = startY + row * (buttonHeight + spacingDown);

            Button(context, x, y, buttonWidth, buttonHeight, net.neb.modules.Module.modules.get(i));
        }

        mouseLeftClicked = false;
        mouseRightClicked = false;
    }
//
//    @Override
//    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
//
//        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
//            MC.setScreen(null);
//        }
//
//        return super.keyPressed(keyCode, scanCode, modifiers);
//    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseY = mouseY;
        this.mouseX = mouseX;

        if(button == GLFW.GLFW_MOUSE_BUTTON_1){
            mouseLeftClicked = true;
        }

        if(button == GLFW.GLFW_MOUSE_BUTTON_2){
            mouseRightClicked = true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if(button == GLFW.GLFW_MOUSE_BUTTON_1){
            mouseLeftClicked = false;
        }

        if(button == GLFW.GLFW_MOUSE_BUTTON_2){
            mouseRightClicked = false;
        }

        return super.mouseReleased(mouseX, mouseY, button);
    }

    public void Button(DrawContext context, int x, int y, int width, int height, Module module){

        context.fill(x, y, x + width, y + height, 0xFF222222);

        context.drawText(Nyx.mc.textRenderer, module.getName(), x + 10,y + 10,0xFFFFFFFF,false);


        context.drawBorder(x, y, width, height, Nyx.MainColor);


        if (module.getState()) {
            context.drawBorder(x, y, width, height, buttonActive);
        }

        if(mouseLeftClicked){
            if (mouseX > x && mouseY > y && mouseX < x + width && mouseY < y + height) {
                module.toggle();
            }
        }

        if(mouseRightClicked){
            if (mouseX > x && mouseY > y && mouseX < x + width && mouseY < y + height) {
                //Nyx.mc.setScreen(new ModuleSettingScreen(module));
                System.out.println("Noch nicht implementiert!");
            }
        }

    }

    @Override
    public boolean shouldPause() {
        return false;
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, this.width, this.height, 0x00000000);
    }
}