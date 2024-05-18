package com.example.maxjnsn.craftablespawners.item;

import com.example.maxjnsn.craftablespawners.CraftableSpawners;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SPAWNER_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CraftableSpawners.MOD_ID, "spawner"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.craftablespawners"))
                    .icon(() -> new ItemStack(ModItems.SPAWNER_FRAGMENT))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SPAWNER_FRAGMENT);
                        entries.add(Items.SPAWNER);
                    })
                    .build());

    public static void registerItemGroups() {
        CraftableSpawners.LOGGER.info("Registering item groups for " + CraftableSpawners.MOD_ID);
    }
}