package com.sakaltj.petobject2.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.entity.ItemEntity;

import java.util.List;

public class MemoriaEntity extends PathAwareEntity {

    protected MemoriaEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 1.0));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            collectNearbyItems();
        }
    }

    private void collectNearbyItems() {
        Box box = this.getBoundingBox().expand(3.0);
        List<ItemEntity> items = this.getWorld().getEntitiesByClass(ItemEntity.class, box, item -> !item.cannotPickup());

        for (ItemEntity item : items) {
            if (item.getStack().isEmpty()) continue;
            item.onPlayerCollision(null); // プレイヤー不在でも回収動作
            item.discard(); // 消去（演出簡略化）
        }
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 50.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }
　}
}
