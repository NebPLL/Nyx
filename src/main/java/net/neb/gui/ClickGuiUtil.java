package net.neb.gui;

public enum ClickGuiUtil {
    ;

    public static boolean isInBox(double x, double y, int width, int height, double mouseX, double mouseY) {
        return x < mouseX && y < mouseY && x + width > mouseX && y + height > mouseY;
    }
}
