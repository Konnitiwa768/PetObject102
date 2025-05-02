package com.sakalti.petobject2.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;

public class CocleaEntity extends TameableEntity {
    private final SimpleInventory inventory = new SimpleInventory(27);
    private boolean waiting = false;
    private BlockPos deathPos = null;

    protected CocleaEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static DefaultAttributeContainer.Builder createCocleaAttributes() {
        return PathAwareEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 78.0)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3);
    }

    @Override
    public void tick() {
        super.tick();

        if (deathPos != null && !world.isClient && !waiting) {
            List<ItemStack> found = world.getEntitiesByClass(ItemEntity.class,
                    new Box(deathPos).expand(64), e -> true).stream()
                    .map(ItemEntity::getStack)
                    .limit(27 - inventory.size())
                    .toList();

            for (ItemStack stack : found) {
                inventory.addStack(stack.copy());
                stack.setCount(0); // remove from world
            }

            deathPos = null; // clear after collection
        }

        if (!world.isClient && getOwner() instanceof PlayerEntity player &&
                this.squaredDistanceTo(player) < 4 && !inventory.isEmpty()) {
            player.sendMessage(Text.literal("どうぞ"), true);
            for (int i = 0; i < inventory.size(); i++) {
                ItemStack stack = inventory.removeStack(i);
                if (!stack.isEmpty()) {
                    player.getInventory().insertStack(stack);
                }
            }
        }
    }

    public void setWaiting(boolean wait) {
        this.waiting = wait;
    }

    public void markDeathPos(BlockPos pos) {
        this.deathPos = pos;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (!waiting) {
            return super.damage(source, amount);
        } else {
            return false;
        }
    }
}
