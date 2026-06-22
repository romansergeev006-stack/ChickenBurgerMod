package com.romchik.chickenburger.init;

import com.romchik.chickenburger.ChickenBurgerMod;
import com.romchik.chickenburger.effect.ChickenTransformationEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ChickenBurgerMod.MOD_ID);

    public static final net.minecraftforge.registries.IForgeRegistryEntry.Impl<Effect> CHICKEN_TRANSFORMATION = EFFECTS.register("chicken_transformation",
            ChickenTransformationEffect::new);
}
