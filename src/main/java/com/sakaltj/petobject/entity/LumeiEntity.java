package com.sakaltj.petobject.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.UUID;

public class LumeiEntity extends TameableEntity {
    private boolean isWaiting = false;

    protected LumeiEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 65.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.31)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(3, new FollowOwnerGoal(this, 1.0, 5.0f, 2.0f, false));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(6, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveTargetGoal<>(this, HostileEntity.class, true));
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (world.isClient) return ActionResult.SUCCESS;

        if (this.isTamed()) {
            if (player.isSneaking()) {
                isWaiting = !isWaiting;
                return ActionResult.SUCCESS;
            }
        } else if (player.getStackInHand(hand).isOf(Items.BLAZE_POWDER)) {
            if (random.nextFloat() < 0.4f) {
                this.setOwner(player);
                this.setTamed(true);
                world.playSound(null, getBlockPos(), SoundEvents.ENTITY_WOLF_TAME, getSoundCategory(), 1.0f, 1.0f);
            } else {
                world.playSound(null, getBlockPos(), SoundEvents.ENTITY_WOLF_WHINE, getSoundCategory(), 1.0f, 1.0f);
            }
            if (!player.isCreative()) {
                player.getStackInHand(hand).decrement(1);
            }
            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }

    @Override
    public boolean canAttackWithOwner(LivingEntity target, LivingEntity owner) {
        return target instanceof HostileEntity;
    }

    public boolean isWaiting() {
        return isWaiting;
    }
}
