package com.sakaltj.petobject2.client.render;

import com.sakalti.petobject2.client.model.NordiaModel;
import com.sakalti.petobject2.entity.NordiaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class NordiaRenderer extends MobEntityRenderer<NordiaEntity, NordiaModel> {
    public static final Identifier TEXTURE = new Identifier("petobject2", "textures/entity/nordia.png");
    public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(new Identifier("petobject2", "nordia"), "main");

    public NordiaRenderer(EntityRendererFactory.Context context) {
        super(context, new NordiaModel(context.getPart(MODEL_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(NordiaEntity entity) {
        return TEXTURE;
    }
}
