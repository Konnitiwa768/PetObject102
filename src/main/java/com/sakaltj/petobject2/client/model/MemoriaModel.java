package com.sakaltj.petobject2.client.model;

import com.sakaltj.petobject2.entity.MemoriaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;

public class MemoriaModel extends EntityModel<MemoriaEntity> {
    private final ModelPart base;

    public MemoriaModel(ModelPart root) {
        this.base = root.getChild("base");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();

        root.addChild("base", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-4, 0, -2, 8, 12, 4), ModelTransform.pivot(0, 0, 0));

        return TexturedModelData.of(data, 64, 32);
    }

    @Override
    public void setAngles(MemoriaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {}

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        base.render(matrices, vertices, light, overlay);
    }
}
