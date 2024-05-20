package com.example.maxjnsn.craftablespawners.mixin;

import com.example.maxjnsn.craftablespawners.enchantment.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getPossibleEntries", at = @At("HEAD"), cancellable = true)
    private static void injectCustomEnchantmentLogic(int power, ItemStack stack, boolean treasureAllowed, CallbackInfoReturnable<List<EnchantmentLevelEntry>> cir) {
        if (stack.getItem() instanceof HoeItem) {
            List<EnchantmentLevelEntry> currentList = cir.getReturnValue();
            if (currentList == null) {
                currentList = new ArrayList<>();
                cir.setReturnValue(currentList);
            }
            currentList.add(new EnchantmentLevelEntry(ModEnchantments.SOUL_REAPER, 1));
        }
    }
}
