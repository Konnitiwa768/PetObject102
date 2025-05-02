package com.sakaltj.petobject.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.Spawner;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.entity.SpawnRestriction;

public class LumeiSpawn {
    public static void register() {
        BiomeModifications.addSpawn(
            BiomeSelectors.categories(Biome.Category.FOREST, Biome.Category.PLAINS),
            SpawnGroup.CREATURE,
            EntityRegistry.LUMEI,
            10, 1, 2
        );

        SpawnRestriction.register(
            EntityRegistry.LUMEI,
            SpawnRestriction.Location.ON_GROUND,
            Heipackage com.sakalti.petobject;

import com.sakalti.petobject.entity.EntityRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.SpawnRestriction;

public class ModSpawns {
    public static void register() {
        BiomeModifications.addSpawn(
            BiomeSelectors.categories(Biome.Category.FOREST, Biome.Category.PLAINS),
            SpawnGroup.CREATURE,
            EntityRegistry.LUMEI,
            10, 1, 2
        );

        SpawnRestriction.register(
            EntityRegistry.LUMEI,
            SpawnRestriction.Location.ON_GROUND,
            Heighpackage com.sakalti.petobject;

import com.sakalti.petobject.entity.EntityRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.SpawnRestriction;

public class ModSpawns {
    public static void register() {
        // Lumei
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.FOREST, Biome.Category.PLAINS),
            SpawnGroup.CREATURE, EntityRegistry.LUMEI, 10, 1, 2);

        SpawnRestriction.register(EntityRegistry.LUMEI,
            SpawnRestriction.Location.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            (type, world, reason, pos, random) -> world.getTimeOfDay() % 24000 >= 13000);

        // Mechanyl
        BiomeModifications.addSpawn(BiomeSelectors.all(),
            SpawnGroup.MONSTER, EntityRegistry.MECHANYL, 8, 1, 2);

        SpawnRestriction.register(EntityRegistry.MECHANYL,
            SpawnRestriction.Location.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            (type, world, reason, pos, random) -> world.getTimeOfDay() % 24000 >= 13000);
    }
}
