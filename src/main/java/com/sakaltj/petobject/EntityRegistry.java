package com.sakaltj.petobject;

import com.sakalti.petobject.entity.LumeiEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {
    public static final EntityType<LumeiEntity> LUMEI = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("petobject", "lumei"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LumeiEntity::new)
            .dimensions(EntityDimensions.fixed(0.6f, 1.4f))
            .build()
    );

    public stapackage com.sakalti.petobject.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityRegistry {
    public static final EntityType<LumeiEntity> LUMEI = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("petobject", "lumei"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LumeiEntity::new)
            .dimensions(EntityDimensions.fixed(0.6f, 1.2f)).build()
    );

    public static final EntityType<MechanylEntity> MECHANYL = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier("petobject", "mechanyl"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MechanylEntity::new)
            .dimensions(EntityDimensions.fixed(0.8f, 1.95f)).build()
    );

    public static void registerAttributes() {
        net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(
            LUMEI, LumeiEntity.createLumeiAttributes());
        net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(
            MECHANYL, MechanylEntity.createAttributes());
    }
}
