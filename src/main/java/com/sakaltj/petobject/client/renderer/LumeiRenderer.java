package com.sakaltj.petobject.client.renderer;

import com.sakalti.petobject.client.model.LumeiModel;
import com.sakalti.petobject.entity.LumeiEntity;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class LumeiRenderer extends MobEntityRenderer<LumeiEntity, LumeiModel> {
    private static final Identifier TEXTURE = new Identifier("petobject", "textures/entity/lumei.png");

    public LumeiRenderer(EntityRendererFactory.Context context) {
        super(context, new LumeiModel(context.getPart(LumeiModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public Identifier getTexture(LumeiEntity entity) {
        return TEXTURE;
    }
}
