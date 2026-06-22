package com.romchik.chickenburger.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.math.AxisAlignedBB;

public class ChickenTransformationEffect extends Effect {
    public ChickenTransformationEffect() {
        super(EffectType.NEUTRAL, 0xFFD700); // Gold color
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            
            // Apply speed effect
            if (!player.isPotionActive(net.minecraft.potion.Effects.SPEED)) {
                player.addPotionEffect(new net.minecraft.potion.EffectInstance(
                        net.minecraft.potion.Effects.SPEED, 20, 2, false, false));
            }
            
            // Apply jump boost
            if (!player.isPotionActive(net.minecraft.potion.Effects.JUMP_BOOST)) {
                player.addPotionEffect(new net.minecraft.potion.EffectInstance(
                        net.minecraft.potion.Effects.JUMP_BOOST, 20, 2, false, false));
            }
            
            // Apply slow falling
            if (!player.isPotionActive(net.minecraft.potion.Effects.SLOW_FALLING)) {
                player.addPotionEffect(new net.minecraft.potion.EffectInstance(
                        net.minecraft.potion.Effects.SLOW_FALLING, 20, 0, false, false));
            }
            
            // Change hitbox to chicken size (smaller)
            AxisAlignedBB originalBox = new AxisAlignedBB(-0.3, 0, -0.3, 0.3, 0.6, 0.3);
            player.setBoundingBox(originalBox);
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 10 == 0;
    }
}
