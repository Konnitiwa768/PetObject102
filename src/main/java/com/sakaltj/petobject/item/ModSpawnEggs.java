package com.sakalti.petobject2;

import com.sakalti.petobject2.entity.EntityRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSpawnEggs {
    public static final Item COCLEA_EGG = new SpawnEggItem(
        EntityRegistry.COCLEA,
        0xC0C0C0, 0xAAAAAA,
        new Item.Settings()
    );

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("petobject2", "coclea_spawn_egg"), COCLEA_EGG);
    }
}
