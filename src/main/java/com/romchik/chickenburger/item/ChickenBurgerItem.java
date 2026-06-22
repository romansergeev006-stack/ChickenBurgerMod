package com.romchik.chickenburger.item;

import com.romchik.chickenburger.init.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

public class ChickenBurgerItem extends net.minecraft.item.Item {
    public ChickenBurgerItem(Properties properties) {
        super(properties.food(new Food.Builder()
                .hunger(10)
                .saturation(12.0f)
                .build()));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack result = super.onItemUseFinish(stack, worldIn, entityLiving);
        
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            if (!worldIn.isRemote) {
                // Apply chicken transformation effect for 60 seconds (1200 ticks)
                player.addPotionEffect(new EffectInstance(ModEffects.CHICKEN_TRANSFORMATION.get(), 1200, 0, false, false));
            }
        }
        
        return result;
    }
}
