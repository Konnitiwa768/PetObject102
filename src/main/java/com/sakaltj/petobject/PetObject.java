package com.sakaltj.petobject;

import com.sakalti.petobject.entity.EntityRegistry;
import net.fabricmc.api.ModInitializer;

public class PetObjectMod implements ModInitializer {
    @Override
    public void onInitialize() {
        EntityRegistry.registerAttributes();
        ModSpawns.register();
        ModSpawnEggs.register();
    }
}
