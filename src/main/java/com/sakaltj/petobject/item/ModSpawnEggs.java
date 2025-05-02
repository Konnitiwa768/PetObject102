package com.sakaltj.item.petobject;

import com.sakalti.petobject.entity.EntityRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSpawnEggs {
    public static final Item LUMEI_SPAWN_EGG = new SpawnEggItem(
        EntityRegistry.LUMEI, 0x222222, 0xffcc00, new Item.Settings().group(ItemGroup.MISC));

    public static final Item MECHANYL_SPAWN_EGG = new SpawnEggItem(
        EntityRegistry.MECHANYL, 0x333333, 0x888888, new Item.Settings().group(ItemGroup.MISC));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("petobject", "lumei_spawn_egg"), LUMEI_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier("petobject", "mechanyl_spawn_egg"), MECHANYL_SPAWN_EGG);
    }
}
