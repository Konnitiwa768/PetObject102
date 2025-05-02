package com.sakaltj.petobject2.client.model;

import com.sakaltj.petobject2.entity.NordiaEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.VertexConsumer;

public class NordiaModel extends EntityModel<NordiaEntity> {
    private final ModelPart base;
    private final ModelPart handle;

    public NordiaModel(ModelPart root) {
        this.base = root.getChild("base");
        this.handle = root.getChild("handle");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        // 本体: 16x4x16
        root.addChild("base", ModelPartBuilder.create()
            .uv(0, 0).cuboid(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F),
            ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        // 取っ手: 2x2x2（上部に中央寄せ）
        root.addChild("handle", ModelPartBuilder.create()
            .uv(0, 20).cuboid(-8.0F, -16.0F, -8.0F, 2.0F, 2.0F, 2.0F),
            ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(NordiaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // 特に動かない
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        base.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        handle.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
