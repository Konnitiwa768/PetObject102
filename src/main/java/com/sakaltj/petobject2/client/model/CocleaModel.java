package com.sakaltj.petobject2.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import com.sakalti.petobject2.entity.CocleaEntity;

public class CocleaModel extends SinglePartEntityModel<CocleaEntity> {
    private final ModelPart root;

    public CocleaModel(ModelPart root) {
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        ModelPartData root = data.getRoot();

        root.addChild("tip", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-2, 0, -3, 4, 1, 6), ModelTransform.NONE);
        root.addChild("handle", ModelPartBuilder.create()
                .uv(0, 8).cuboid(-8, -1, -1, 16, 2, 2), ModelTransform.NONE);

        return TexturedModelData.of(data, 32, 16);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setAngles(CocleaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {}
}
