package com.sakaltj.petobject2.client.model;

import com.sakaltj.petobject2.entity.MemoriaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;

public class MemoriaModel extends EntityModel<MemoriaEntity> {
    private final ModelPart body;

    public MemoriaModel(ModelPart root) {
        this.body = root.getChild("body");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // USBスティック型本体
        root.addChild("body", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-1.5F, 0F, -1.5F, 3, 8, 3), // 細長い立方体
                ModelTransform.pivot(0, 16, 0)); // 地面から少し浮かせて配置

        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(MemoriaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {}

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertices, light, overlay);
    }
}
