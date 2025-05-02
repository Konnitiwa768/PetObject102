package com.sakaltj.petobject2.client;

import com.sakaltj.petobject2.EntityRegistry;
import com.sakaltj.petobject2.client.renderer.CocleaRenderer;
import com.sakaltj.petobject2.client.renderer.NordiaRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.entity.EntityRenderers;

public class PetObject2Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRenderers.register(EntityRegistry.NORDIA, NordiaRenderer::new);
        EntityRenderers.register(EntityRegistry.COCLEA, CocleaRenderer::new);
    }
}
