package com.sakaltj.petobject.client.renderer;

import com.sakalti.petobject.entity.MechanylEntity;
import com.sakalti.petobject.client.model.MechanylModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class MechanylRenderer extends MobEntityRenderer<MechanylEntity, MechanylModel> {

    private static final Identifier TEXTURE = new Identifier("petobject", "textures/entity/mechanyl.png");

    public MechanylRenderer(EntityRendererFactory.Context context) {
        super(context, new MechanylModel(context.getPart(MechanylModel.LAYER)), 0.6f);
    }

    @Override
    public Identifier getTexture(MechanylEntity entity) {
        return TEXTURE;
    }
}
