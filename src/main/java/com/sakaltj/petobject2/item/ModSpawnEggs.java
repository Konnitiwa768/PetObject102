package com.sakalti.petobject2.registry;

import com.sakalti.petobject2.entity.EntityRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSpawnEggs {

    public static final Item NORDENTIA_SPAWN_EGG = register("nordnetia_spawn_egg", new SpawnEggItem(EntityRegistry.NORDENTIA, 0x000000, 0xFFFFFF, new Item.Settings()));
    public static final Item COCLEA_SPAWN_EGG = register("coclea_spawn_egg", new SpawnEggItem(EntityRegistry.COCLEA, 0xAAAAAA, 0xBBBBBB, new Item.Settings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier("petobject2", name), item);
    }
}
