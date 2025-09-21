package de.neb.util.render;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import de.neb.Nyx;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.util.Identifier;

import java.util.OptionalDouble;

public enum NyxRenderLayer {
    ;

    public static final RenderPipeline ESP_LINES =
            RenderPipelines.register(RenderPipeline.builder(RenderPipelines.RENDERTYPE_LINES_SNIPPET)
                    .withLocation(Identifier.of(Nyx.MOD_ID, "esp_lines"))
                    .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
                    .build());

    public static final net.minecraft.client.render.RenderLayer.MultiPhase ESP_LINES_LAYER = net.minecraft.client.render.RenderLayer.of(
            Nyx.MOD_ID + ":esp_lines",
            VertexFormat.DrawMode.LINES.ordinal(),
            ESP_LINES,
            net.minecraft.client.render.RenderLayer.MultiPhaseParameters.builder()
                    .lineWidth(new RenderPhase.LineWidth(OptionalDouble.of(2.0)))
                    .layering(net.minecraft.client.render.RenderLayer.VIEW_OFFSET_Z_LAYERING_FORWARD)
                    .build(false)
    );

    public static RenderLayer getLines(){
        return  ESP_LINES_LAYER;
    }

    // Quads-Pipeline
    public static final RenderPipeline ESP_QUADS_PIPELINE = RenderPipelines
            .register(RenderPipeline.builder(RenderPipelines.POSITION_COLOR_SNIPPET)
                    .withLocation(Identifier.of(Nyx.MOD_ID, "esp_quads"))
                    .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
                    .build());

    public static final net.minecraft.client.render.RenderLayer.MultiPhase ESP_QUADS = net.minecraft.client.render.RenderLayer.of(
            Nyx.MOD_ID + ":esp_quads",
            VertexFormat.DrawMode.QUADS.ordinal(),
            ESP_QUADS_PIPELINE,
            net.minecraft.client.render.RenderLayer.MultiPhaseParameters.builder().build(false)
    );

    public static RenderLayer getQuads(){
        return ESP_QUADS;
    }
}
