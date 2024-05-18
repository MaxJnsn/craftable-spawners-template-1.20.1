package com.example.maxjnsn.craftablespawners.block.custom;

import com.example.maxjnsn.craftablespawners.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class EmptySpawner extends Block {
    public EmptySpawner(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == ModItems.SKELETON_TRANSFORMER) {
            if (!world.isClient()) {
                world.setBlockState(pos, Blocks.SPAWNER.getDefaultState());

                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof MobSpawnerBlockEntity) {
                    MobSpawnerBlockEntity spawner = (MobSpawnerBlockEntity) blockEntity;
                    Random random = world.getRandom();  // Get the Random object from the world

                    // Assume setEntityId now needs the world, a Random object, BlockPos, and EntityType
                    spawner.getLogic().setEntityId(EntityType.SKELETON, world, random, pos);

                    return ActionResult.SUCCESS;
                }
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

}
