package com.jigsaw.jigsawevents.items;

import com.jigsaw.jigsawevents.JigsawEvents;
import com.jigsaw.jigsawevents.items.bigDickRandy.randyHat.RandyHatItem;
import com.jigsaw.jigsawevents.items.bigDickRandy.randyHat.RandyHatMaterial;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * ItemInit
 */
public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, JigsawEvents.MODID);

    public static final RegistryObject<Item> RANDYHAT = ITEMS.register("randy_hat", () -> new RandyHatItem.Helmet());


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
