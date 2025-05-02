package com.sakaltj.petobject.client.model;

import com.sakalti.petobject.entity.MechanylEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class MechanylModel extends EntityModel<MechanylEntity> {
    private final ModelPart root;

    public static final EntityModelLayer LAYER = new EntityModelLayer(
        new Identifier("petobject", "mechanyl"), "main");

    public MechanylModel(ModelPart root) {
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        data.getRoot().addChild("cube",
            ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-8.0F, -8.0F, -8.0F, 16, 16, 16, new Dilation(0.0F)),
            ModelTransform.pivot(0.0F, 8.0F, 0.0F));
        return TexturedModelData.of(data, 64, 64);
    }

    @Override
    public void setAngles(MechanylEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {}

    @Override
    public void render(net.minecraft.client.render.VertexConsumerProvider matrices, float tickDelta, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, light, overlay, red, green, blue, alpha);
    }
}
