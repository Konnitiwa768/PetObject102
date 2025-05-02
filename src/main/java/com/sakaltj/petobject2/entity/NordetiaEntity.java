package com.sakalti.petobject2.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

public class NordetiaEntity extends TameableEntity {
    private int attackCount = 0; // 連続攻撃回数
    private long lastAttackTime = 0; // 最後の攻撃時間
    private boolean isStunned = false; // スタン状態

    protected NordetiaEntity(EntityType<? extends TameableEntity> type, World world) {
        super(type, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return TameableEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 114.0)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 14.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0);
    }

    @Override
    public void tick() {
        super.tick();

        if (isStunned && this.age % 20 == 0) { // スタン中は20ティックごとに解除
            isStunned = false;
        }
    }

    @Override
    public void damage(DamageSource source, float amount) {
        if (source.getAttacker() instanceof PlayerEntity player) {
            long currentTime = world.getTime();
            // 2秒以内に連続攻撃された場合、攻撃回数をカウント
            if (currentTime - lastAttackTime <= 40) { 
                attackCount++;
            } else {
                attackCount = 1; // 時間経過でリセット
            }
            lastAttackTime = currentTime;

            // 連続攻撃によるダメージ増加
            float increasedDamage = amount * (1.2F * Math.pow(attackCount * 1.2, attackCount - 1));

            super.damage(source, increasedDamage); 

            // 5回攻撃でスタン
            if (attackCount >= 5) {
                isStunned = true;
                attackCount = 0; // スタン後、カウントリセット
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
