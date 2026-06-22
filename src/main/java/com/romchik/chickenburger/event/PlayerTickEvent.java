package com.romchik.chickenburger.event;

import com.romchik.chickenburger.init.ModEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "chickenburger", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerTickEvent {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        EffectInstance effect = player.getActivePotionEffect(ModEffects.CHICKEN_TRANSFORMATION.get());

        if (effect != null) {
            // Update hitbox to chicken size
            AxisAlignedBB chickenBox = new AxisAlignedBB(
                    player.getX() - 0.3,
                    player.getY(),
                    player.getZ() - 0.3,
                    player.getX() + 0.3,
                    player.getY() + 0.6,
                    player.getZ() + 0.3
            );
            player.setBoundingBox(chickenBox);
        }
    }
}
