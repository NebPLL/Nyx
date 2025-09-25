package net.neb.gui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.neb.Nyx;
import net.neb.modules.Category;
import net.neb.modules.Categorys;
import net.neb.modules.Module;
import org.lwjgl.glfw.GLFW;

public class ClickGui extends Screen {

    Categorys categorys = new Categorys();
    Category draggedCategory = null;

    boolean mouseDragging = false;
    boolean mouseLeftClicked = false;
    boolean mouseRightClicked = false;

    int CategoryTitleStartX = 10;
    int CategoryTitleStartY = 10;
    int CategoryTitleStartWidth = 50;
    int CategoryTitleStartHeight = 20;
    int CategoryTitleSpacingWidth = 10;

    int CategoryBorderColor = 0xFF000000;
    int CategoryTextColor = 0xFFFFFFFF;
    int ModuleActiveColor = 0xFF00FF00;

    int TextBoxIndent = 5;

    int x = 100;
    int y = 100;

    int dragOffsetX;
    int dragOffsetY;

    public ClickGui() {
        super(Text.of("Nyx click gui"));
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (button == GLFW.GLFW_MOUSE_BUTTON_1){

            for (Category category : categorys.Categorys) {
                if (draggedCategory == null && ClickGuiUtil.isInBox(category.x, category.y, CategoryTitleStartWidth, CategoryTitleStartHeight, mouseX, mouseY)) {

                    this.mouseDragging = true;
                    draggedCategory = category;
                    dragOffsetX = (int) (mouseX - category.x);
                    dragOffsetY = (int) (mouseY - category.y);
                }
            }
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == GLFW.GLFW_MOUSE_BUTTON_1) {
            mouseLeftClicked = true;
        }

        if (button == GLFW.GLFW_MOUSE_BUTTON_2) {
            mouseRightClicked = true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == GLFW.GLFW_MOUSE_BUTTON_1) {
            mouseDragging = false;
            mouseLeftClicked = false;
            draggedCategory = null;
        }

        if (button == GLFW.GLFW_MOUSE_BUTTON_2) {
            mouseRightClicked = false;
        }

        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);

        if (mouseDragging && draggedCategory != null) {
            draggedCategory.x = mouseX - dragOffsetX;
            draggedCategory.y = mouseY - dragOffsetY;
        }

        for (Category category : categorys.Categorys){

            // Render Title
            context.drawText(Nyx.mc.textRenderer, category.name, category.x + TextBoxIndent, category.y + TextBoxIndent, CategoryTextColor, false);
            context.drawBorder(category.x, category.y, CategoryTitleStartWidth, CategoryTitleStartHeight, CategoryBorderColor);

            // Disable Seeing Modules

            if (ClickGuiUtil.isInBox(category.x, category.y, CategoryTitleStartWidth,CategoryTitleStartHeight,mouseX,mouseY) && mouseRightClicked) {category.showModules = !category.showModules; mouseRightClicked = false;}

            // Modules
            int i = 1;
            for (Module module : category.getModuleList()) {

                if (category.showModules) continue;

                int mX = category.x;
                int mY = category.y + (i * CategoryTitleStartHeight) - 1;

                if (ClickGuiUtil.isInBox(mX,mY, CategoryTitleStartWidth, CategoryTitleStartHeight, mouseX, mouseY) && mouseLeftClicked) {module.toggle(); System.out.println("Toggled"); mouseLeftClicked = false;}

                if (module.getState()) context.drawBorder(mX, mY , CategoryTitleStartWidth, CategoryTitleStartHeight , ModuleActiveColor);
                else context.drawBorder(mX, mY, CategoryTitleStartWidth, CategoryTitleStartHeight , CategoryBorderColor);

                context.drawText(Nyx.mc.textRenderer, module.getName(), category.x + TextBoxIndent , mY + TextBoxIndent, CategoryTextColor, false);
                i++;
            }

        }
    }
}
