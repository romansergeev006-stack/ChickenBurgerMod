package com.romchik.chickenburger.init;

import com.romchik.chickenburger.ChickenBurgerMod;
import com.romchik.chickenburger.item.ChickenBurgerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChickenBurgerMod.MOD_ID);

    public static final net.minecraftforge.registries.IForgeRegistryEntry.Impl<Item> CHICKEN_BURGER = ITEMS.register("chicken_burger",
            () -> new ChickenBurgerItem(new Item.Properties()
                    .group(ItemGroup.FOOD)
                    .maxStackSize(64)));
}
