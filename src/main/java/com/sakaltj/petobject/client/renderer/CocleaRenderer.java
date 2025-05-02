package com.sakalti.petobject2.client.renderer;

import com.sakalti.petobject2.client.model.CocleaModel;
import com.sakalti.petobject2.entity.CocleaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class CocleaRenderer extends MobEntityRenderer<CocleaEntity, CocleaModel> {
    public CocleaRenderer(EntityRendererFactory.Context context) {
        super(context, new CocleaModel(context.getPart(ModClient.COCLEA_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(CocleaEntity entity) {
        return new Identifier("petobject2", "textures/entity/coclea.png");
    }
}
