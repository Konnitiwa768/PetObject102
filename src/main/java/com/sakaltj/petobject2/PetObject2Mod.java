package com.sakaltj.petobject2;

import com.sakalti.petobject.entity.EntityRegistry;
import net.fabricmc.api.ModInitializer;

public class PetObject2Mod implements ModInitializer {
    @Override
    public void onInitialize() {
        EntityRegistry.registerAttributes();
        ModSpawns.register();
        ModSpawnEggs.register();
    }
}
