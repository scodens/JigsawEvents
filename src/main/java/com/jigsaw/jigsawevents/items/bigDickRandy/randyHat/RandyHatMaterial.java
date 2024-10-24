package com.jigsaw.jigsawevents.items.bigDickRandy.randyHat;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.jigsaw.jigsawevents.JigsawEvents;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
/**
 * RandyHatMaterial
 */
public enum RandyHatMaterial implements ArmorMaterial{
    RANDY("randy", 26, new int[]{2, 5, 6, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F);

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;

    private final static int[] DURABILITYMULTI = {15, 31, 22, 11};


    private RandyHatMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound,
    float toughness, float knockbackResistance) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
    }


    @Override
    public int getDurabilityForType(Type pType) {
        return DURABILITYMULTI[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return JigsawEvents.MODID + ":" + name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
    
}
