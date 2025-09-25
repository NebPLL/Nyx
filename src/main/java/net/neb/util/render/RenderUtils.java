package net.neb.util.render;

import net.neb.Nyx;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Box;

public enum RenderUtils {
    ;

    public static void drawOutlinedBox(MatrixStack matrices,
                                Box box, int color)
    {
        MatrixStack.Entry entry = matrices.peek();
        VertexConsumerProvider.Immediate VCP = Nyx.mc.getBufferBuilders().getEffectVertexConsumers();
        net.minecraft.client.render.RenderLayer layer = NyxRenderLayer.getLines();
        VertexConsumer buffer = VCP.getBuffer(layer);


        float x1 = (float)box.minX;
        float y1 = (float)box.minY;
        float z1 = (float)box.minZ;
        float x2 = (float)box.maxX;
        float y2 = (float)box.maxY;
        float z2 = (float)box.maxZ;

        // bottom lines
        buffer.vertex(entry, x1, y1, z1).color(color).normal(entry, 1, 0, 0);
        buffer.vertex(entry, x2, y1, z1).color(color).normal(entry, 1, 0, 0);
        buffer.vertex(entry, x1, y1, z1).color(color).normal(entry, 0, 0, 1);
        buffer.vertex(entry, x1, y1, z2).color(color).normal(entry, 0, 0, 1);
        buffer.vertex(entry, x2, y1, z1).color(color).normal(entry, 0, 0, 1);
        buffer.vertex(entry, x2, y1, z2).color(color).normal(entry, 0, 0, 1);
        buffer.vertex(entry, x1, y1, z2).color(color).normal(entry, 1, 0, 0);
        buffer.vertex(entry, x2, y1, z2).color(color).normal(entry, 1, 0, 0);

        // top lines
        buffer.vertex(entry, x1, y2, z1).color(color).normal(entry, 1, 0, 0);
        buffer.vertex(entry, x2, y2, z1).color(color).normal(entry, 1, 0, 0);
        buffer.vertex(entry, x1, y2, z1).color(color).normal(entry, 0, 0, 1);
        buffer.vertex(entry, x1, y2, z2).color(color).normal(entry, 0, 0, 1);
        buffer.vertex(entry, x2, y2, z1).color(color).normal(entry, 0, 0, 1);
        buffer.vertex(entry, x2, y2, z2).color(color).normal(entry, 0, 0, 1);
        buffer.vertex(entry, x1, y2, z2).color(color).normal(entry, 1, 0, 0);
        buffer.vertex(entry, x2, y2, z2).color(color).normal(entry, 1, 0, 0);

        // side lines
        buffer.vertex(entry, x1, y1, z1).color(color).normal(entry, 0, 1, 0);
        buffer.vertex(entry, x1, y2, z1).color(color).normal(entry, 0, 1, 0);
        buffer.vertex(entry, x2, y1, z1).color(color).normal(entry, 0, 1, 0);
        buffer.vertex(entry, x2, y2, z1).color(color).normal(entry, 0, 1, 0);
        buffer.vertex(entry, x1, y1, z2).color(color).normal(entry, 0, 1, 0);
        buffer.vertex(entry, x1, y2, z2).color(color).normal(entry, 0, 1, 0);
        buffer.vertex(entry, x2, y1, z2).color(color).normal(entry, 0, 1, 0);
        buffer.vertex(entry, x2, y2, z2).color(color).normal(entry, 0, 1, 0);

        VCP.draw(layer);
    }
    public static void drawSolidBox(MatrixStack matrices,
                             Box box, int color)
    {
        MatrixStack.Entry entry = matrices.peek();
        VertexConsumerProvider.Immediate VCP = Nyx.mc.getBufferBuilders().getEffectVertexConsumers();
        RenderLayer layer = NyxRenderLayer.getQuads();
        VertexConsumer buffer = VCP.getBuffer(layer);

        float x1 = (float)box.minX;
        float y1 = (float)box.minY;
        float z1 = (float)box.minZ;
        float x2 = (float)box.maxX;
        float y2 = (float)box.maxY;
        float z2 = (float)box.maxZ;
        buffer.vertex(entry, x1, y1, z1).color(color);
        buffer.vertex(entry, x2, y1, z1).color(color);
        buffer.vertex(entry, x2, y1, z2).color(color);
        buffer.vertex(entry, x1, y1, z2).color(color);

        buffer.vertex(entry, x1, y2, z1).color(color);
        buffer.vertex(entry, x1, y2, z2).color(color);
        buffer.vertex(entry, x2, y2, z2).color(color);
        buffer.vertex(entry, x2, y2, z1).color(color);

        buffer.vertex(entry, x1, y1, z1).color(color);
        buffer.vertex(entry, x1, y2, z1).color(color);
        buffer.vertex(entry, x2, y2, z1).color(color);
        buffer.vertex(entry, x2, y1, z1).color(color);

        buffer.vertex(entry, x2, y1, z1).color(color);
        buffer.vertex(entry, x2, y2, z1).color(color);
        buffer.vertex(entry, x2, y2, z2).color(color);
        buffer.vertex(entry, x2, y1, z2).color(color);

        buffer.vertex(entry, x1, y1, z2).color(color);
        buffer.vertex(entry, x2, y1, z2).color(color);
        buffer.vertex(entry, x2, y2, z2).color(color);
        buffer.vertex(entry, x1, y2, z2).color(color);

        buffer.vertex(entry, x1, y1, z1).color(color);
        buffer.vertex(entry, x1, y1, z2).color(color);
        buffer.vertex(entry, x1, y2, z2).color(color);
        buffer.vertex(entry, x1, y2, z1).color(color);

        VCP.draw(layer);
    }
}
