package com.example.maxjnsn.craftablespawners.enchantment;

import com.example.maxjnsn.craftablespawners.CraftableSpawners;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final Enchantment SOUL_REAPER = registerEnchantment("soul_reaper",
            new SoulReaperEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment registerEnchantment(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(CraftableSpawners.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        CraftableSpawners.LOGGER.info("Registering enchantments for " + CraftableSpawners.MOD_ID);
    }
}
