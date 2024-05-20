package com.example.maxjnsn.craftablespawners.mixin;

import java.util.ArrayList;
import java.util.List;

import com.example.maxjnsn.craftablespawners.enchantment.ModEnchantments;
import net.minecraft.item.HoeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.ItemStack;


// Enchantment.isAcceptableItem() = allowed for anvils? I noticed EfficiencyEnchantment has override to allow shears
@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {
    /**
     * Get list of possible enchantments of an item at an enchantment table.
     */
    @Inject(method = "getPossibleEntries", at = @At("RETURN"))
    private static void enchantableShearsMixin_EnchantmentHelper_getPossibleEntries(
            int power, ItemStack stack, boolean treasureAllowed,
            CallbackInfoReturnable<List<EnchantmentLevelEntry>> cir) {

        // list of enchantments, and level
        List<EnchantmentLevelEntry> list = cir.getReturnValue(); // MUTATED LATER
        ArrayList<Enchantment> newEnchantments = new ArrayList<>(2);

        if (stack.getItem() instanceof HoeItem) {
            newEnchantments.add(ModEnchantments.SOUL_REAPER);
        }
    }
}
