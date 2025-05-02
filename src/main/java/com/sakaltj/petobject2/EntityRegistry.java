package com.sakalti.petobject2;

import com.sakalti.petobject2.entity.CocleaEntity;
import com.sakalti.petobject2.entity.NordnetiaEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class EntityRegistry {

    public static final EntityType<NordnetiaEntity> NORDENTIA = register("nordnetia", EntityType.Builder.create(NordnetiaEntity::new, SpawnGroup.MONSTER).dimensions(EntityDimensions.fixed(16, 4)).build("nordnetia"));
    public static final EntityType<CocleaEntity> COCLEA = register("coclea", EntityType.Builder.create(CocleaEntity::new, SpawnGroup.CREATURE).dimensions(EntityDimensions.fixed(16, 2)).build("coclea"));

    private static <T extends Entity> EntityType<T> register(String name, EntityType<T> type) {
        return Registry.register(Registry.ENTITY_TYPE, new Identifier("petobject2", name), type);
    }
}
