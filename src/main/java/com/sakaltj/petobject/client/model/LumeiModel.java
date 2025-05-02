package com.sakaltj.petobject.client.model;

import com.sakalti.petobject.entity.LumeiEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.math.MatrixStack;

public class LumeiModel extends SinglePartEntityModel<LumeiEntity> {
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier("petobject", "lumei"), "main");
    private final ModelPart root;

    public LumeiModel(ModelPart root) {
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();

        root.addChild("base", ModelPartBuilder.create().uv(0, 0).cuboid(-8, 0, -8, 16, 1, 16), ModelTransform.pivot(0, 23, 0));
        root.addChild("body", ModelPartBuilder.create().uv(0, 17).cuboid(-4, -12, -4, 8, 12, 8), ModelTransform.pivot(0, 23, 0));
        root.addChild("top", ModelPartBuilder.create().uv(32, 0).cuboid(-6, -13, -6, 12, 1, 12), ModelTransform.pivot(0, 23, 0));
        root.addChild("core", ModelPartBuilder.create().uv(32, 13).cuboid(-1, -1, -1, 2, 2, 2), ModelTransform.pivot(0, 17, 0));

        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setAngles(LumeiEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // 動きは無し。浮遊処理などあればここで。
    }
}
