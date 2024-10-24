package com.jigsaw.jigsawevents.items.bigDickRandy.randyHat;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.Minecraft;

import java.util.Map;
import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.jigsaw.jigsawevents.items.bigDickRandy.randyHat.randyHatModel.RandyHatModel;

import java.util.Collections;
/**
 * RadioHatItem
 */
public class RandyHatItem extends ArmorItem {
    

    public RandyHatItem(ArmorItem.Type type, Item.Properties properties) {
        super(RandyHatMaterial.RANDY, type, properties);
    }

    public static class Helmet extends RandyHatItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

        @Override
        public void initializeClient(Consumer<IClientItemExtensions> consumer) {
            consumer.accept(new IClientItemExtensions() {
                @Override
                public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                        EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                    HumanoidModel ArmorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
                        Map.of("head", new RandyHatModel(Minecraft.getInstance().getEntityModels().bakeLayer(RandyHatModel.LAYER_LOCATION)).Head,
                        "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                        "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                    ArmorModel.crouching = livingEntity.isCrouching();
                    ArmorModel.riding = original.riding;
                    ArmorModel.young = original.young;
                    return ArmorModel;
                }
            });
        }
        


        @Override
        public void onArmorTick(ItemStack stack, Level level, Player player) {
            if(!level.isClientSide) {
                // if (player.isShiftKeyDown() && !player.isCreative()) {
                //     if(player.getBlockStateOn().getBlock() == Blocks.AIR) {
                //         player.setDeltaMovement(player.getDeltaMovement().add(0, 10, 0));
                //     }
                // }
            }
        }

        private void addEffect(MobEffectInstance pEffect, Player player) {
            if(!player.hasEffect(pEffect.getEffect())){
                player.addEffect(pEffect);
            }
        }


        @Override
        public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return "jigsawevents:textures/entities/randyhat.png";
        }
    }
    

    
}
