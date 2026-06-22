package com.romchik.chickenburger.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.romchik.chickenburger.client.model.ChickenModel;
import com.romchik.chickenburger.init.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "chickenburger", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ChickenPlayerRenderer {
    private static final ChickenModel CHICKEN_MODEL = new ChickenModel();
    private static final ResourceLocation CHICKEN_TEXTURE = new ResourceLocation("chickenburger", "textures/entity/chicken_player.png");

    @SubscribeEvent
    public static void onRenderPlayerPre(RenderPlayerEvent.Pre event) {
        AbstractClientPlayerEntity player = event.getPlayer();
        EffectInstance effect = player.getActivePotionEffect(ModEffects.CHICKEN_TRANSFORMATION.get());

        if (effect != null) {
            event.setCanceled(true);
            
            MatrixStack matrixStack = event.getMatrixStack();
            IRenderTypeBuffer buffer = event.getBuffers();
            int light = event.getLight();
            
            matrixStack.push();
            
            // Render chicken model
            CHICKEN_MODEL.setLivingAnimations(player, event.getPartialRenderTick(), event.getPartialRenderTick(), Minecraft.getInstance().world != null ? Minecraft.getInstance().world.getGameTime() : 0);
            CHICKEN_MODEL.render(matrixStack, buffer.getBuffer(RenderType.getEntityCutout(CHICKEN_TEXTURE)), light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            
            matrixStack.pop();
        }
    }
}
