package com.sakaltj.petobject.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;

public class MechanylEntity extends HostileEntity {

    protected MechanylEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
        this.experiencePoints = 10;
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 55.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(5, new PickUpItemGoal(this, true));
    }

    @Override
    public boolean canPickUpLoot() {
        return true;
    }

    @Override
    protected void loot(ItemEntity itemEntity) {
        ItemStack stack = itemEntity.getStack();
        if (stack.getItem() instanceof ArmorItem armor) {
            this.equipStack(armor.getSlotType(), stack.copy());
            itemEntity.discard();
        } else if (stack.getItem() instanceof ToolItem || stack.getItem() instanceof RangedWeaponItem) {
            this.equipStack(EquipmentSlot.MAINHAND, stack.copy());
            itemEntity.discard();
        }
    }

    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);
        Random random = this.getRandom();
        this.dropStack(new ItemStack(Items.REDSTONE, 1 + random.nextInt(2)));
        if (random.nextFloat() < 0.5f) this.dropStack(new ItemStack(Items.IRON_INGOT));
        if (random.nextFloat() < 0.3f) this.dropStack(new ItemStack(Items.GOLD_INGOT));
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 1.6f;
    }
}
