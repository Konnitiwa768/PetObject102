package com.sakalti.petobject2.client;

import com.sakalti.petobject2.client.model.CocleaModel;
import com.sakalti.petobject2.client.renderer.CocleaRenderer;
import com.sakalti.petobject2.entity.EntityRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModClient implements ClientModInitializer {
    public static final EntityModelLayer COCLEA_LAYER = new EntityModelLayer(new Identifier("petobject2", "coclea"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityRegistry.COCLEA, CocleaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(COCLEA_LAYER, CocleaModel::getTexturedModelData);
    }
}
