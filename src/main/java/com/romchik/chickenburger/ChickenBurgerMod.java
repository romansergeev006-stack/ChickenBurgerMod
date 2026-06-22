package com.romchik.chickenburger;

import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafxmod.FXModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.romchik.chickenburger.init.ModItems.ITEMS;
import static com.romchik.chickenburger.init.ModEffects.EFFECTS;

@Mod("chickenburger")
public class ChickenBurgerMod {
    public static final String MOD_ID = "chickenburger";
    private static final Logger LOGGER = LogManager.getLogger();

    public ChickenBurgerMod() {
        IEventBus modEventBus = FXModLoadingContext.getInstance().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
        
        ITEMS.register(modEventBus);
        EFFECTS.register(modEventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Chicken Burger Mod loaded!");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
    }
}
