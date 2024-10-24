package com.jigsaw.jigsawevents.misc.models;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;

import com.jigsaw.jigsawevents.JigsawEvents;
import com.jigsaw.jigsawevents.items.bigDickRandy.randyHat.randyHatModel.RandyHatModel;

import net.minecraftforge.api.distmarker.Dist;

/**
 * JigsawEventsModel
 */
@Mod.EventBusSubscriber(modid = JigsawEvents.MODID,bus = Mod.EventBusSubscriber.Bus.MOD, value = { Dist.CLIENT })
public class JigsawEventsEvents {
    @SubscribeEvent
    public static void onEntityRenderers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RandyHatModel.LAYER_LOCATION, RandyHatModel::createBodyLayer);
    }

}
