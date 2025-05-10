package com.sakaltj.petobject2.client;

import com.sakaltj.petobject2.EntityRegistry;
import com.sakaltj.petobject2.client.renderer.*
import com.sakaltj.petobject2.client.model.*
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.entity.EntityRenderers;

public class PetObject2Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRenderers.register(EntityRegistry.NORDIA, NordiaRenderer::new);
        EntityRenderers.register(EntityRegistry.COCLEA, CocleaRenderer::new);
        EntityRendererRegistry.register(EntityRegistry.MEMORIA, MemoriaRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MEMORIA_LAYER, MemoriaModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(NORDIA_LAYER, NordiaModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(COCLEA_LAYER, CocleaModel::getTexturedModelData);
    }
}
