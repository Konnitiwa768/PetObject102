package com.sakalti.petobject2;

import com.sakalti.petobject2.entity.CocleaEntity;
import com.sakalti.petobject2.entity.NordiaEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class EntityRegistry {

    public static final EntityType<NordiaEntity> NORDIA = register("nordia", EntityType.Builder.create(NordiaEntity::new, SpawnGroup.MONSTER).dimensions(EntityDimensions.fixed(16, 4)).build("nordia"));
    public static final EntityType<CocleaEntity> COCLEA = register("coclea", EntityType.Builder.create(CocleaEntity::new, SpawnGroup.CREATURE).dimensions(EntityDimensions.fixed(16, 2)).build("coclea"));

    private static <T extends Entity> EntityType<T> register(String name, EntityType<T> type) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier("petobject2", name), type);
    }
}
