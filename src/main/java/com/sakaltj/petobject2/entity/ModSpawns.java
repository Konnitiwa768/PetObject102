package com.sakalti.petobject2.entity;

import com.sakalti.petobject2.EntityRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.BiomeSelectors;
import net.minecraft.world.SpawnSettings;

public class ModSpawns {
    public static void register() {
        BiomeModifications.addSpawn(
            BiomeSelectors.all(),
            SpawnGroup.CREATURE,
            EntityRegistry.COCLEA,
            10, 1, 2
        );
    }
}
