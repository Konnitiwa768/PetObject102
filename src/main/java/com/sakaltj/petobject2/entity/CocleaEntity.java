package com.sakalti.petobject2.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemEntity;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

import java.util.List;

public class CocleaEntity extends TameableEntity {
    private final SimpleInventory inventory = new SimpleInventory(27);
    private boolean waiting = false;
    private BlockPos deathPos = null;

    protected CocleaEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return TameableEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 78.0)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0);
    }

    public void setWaiting(boolean wait) {
        this.waiting = wait;
    }

    public void markDeathPos(BlockPos pos) {
        this.deathPos = pos;
    }

    @Override
    public void tick() {
        super.tick();

        if (deathPos != null && !world.isClient && !waiting) {
            List<ItemEntity> items = world.getEntitiesByClass(ItemEntity.class, new Box(deathPos).expand(64), e -> true);
            for (ItemEntity item : items) {
                if (inventory.canInsert(item.getStack())) {
                    inventory.addStack(item.getStack().copy());
                    item.discard();
                }
            }
            deathPos = null;
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

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        // 手なずけロジック（鉄インゴット使用）
        if (!this.world.isClient && !this.isTamed() && stack.isOf(Items.IRON_INGOT)) {
            if (this.random.nextFloat() < 0.4F) { // 40% の確率で手なずけ成功
                this.setOwner(player);
                this.world.sendEntityStatus(this, (byte)7); // ハート
            } else {
                this.world.sendEntityStatus(this, (byte)6); // 煙
            }

            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }

            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }
}
