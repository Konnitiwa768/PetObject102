package com.sakaltj.petobject2.entity;

import com.sakaltj.petobject2.EntityRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;

public class ModSpawns {

    public static void register() {
        // 属性登録
        FabricDefaultAttributeRegistry.register(EntityRegistry.NORDIA, NordiaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(EntityRegistry.COCLEA, CocleaEntity.createAttributes());

        // Nordia: すべてのOVERWORLDのバイオームでスポーン
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.MONSTER,
            EntityRegistry.NORDIA,
            10, 1, 2
        );

        // Coclea: 平原と森に出現
        BiomeModifications.addSpawn(
            BiomeSelectors.categories(Biome.Category.FOREST, Biome.Category.PLAINS),
            SpawnGroup.CREATURE,
            EntityRegistry.COCLEA,
            8, 1, 1
        );
    }
}
