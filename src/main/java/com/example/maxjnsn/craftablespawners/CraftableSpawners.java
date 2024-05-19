package com.example.maxjnsn.craftablespawners;

import com.example.maxjnsn.craftablespawners.block.ModBlocks;
import com.example.maxjnsn.craftablespawners.enchantment.ModEnchantments;
import com.example.maxjnsn.craftablespawners.item.ModItemGroups;
import com.example.maxjnsn.craftablespawners.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CraftableSpawners implements ModInitializer {
	public static final String MOD_ID = "craftablespawners";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerItems();
		ModBlocks.registerModBlocks();

		ModEnchantments.registerModEnchantments();
	}
}