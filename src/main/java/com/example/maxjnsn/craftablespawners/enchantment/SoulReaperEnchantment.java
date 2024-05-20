package com.example.maxjnsn.craftablespawners.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;

import static com.example.maxjnsn.craftablespawners.item.ModItems.SKELETON_TRANSFORMER;

public class SoulReaperEnchantment extends Enchantment {
    private static final Map<Entity, Long> recentlyHit = new WeakHashMap<>();
    private final Random random = new Random();

    public SoulReaperEnchantment(Rarity weight, EnchantmentTarget weapon, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.WEAPON, slotTypes);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof HoeItem;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.getWorld().isClient() && target instanceof SkeletonEntity && !target.isAlive()) {
            long currentTime = System.currentTimeMillis();
            Long lastHitTime = recentlyHit.get(target);
            if (lastHitTime == null || (currentTime - lastHitTime) > 1000) {
                recentlyHit.put(target, currentTime);

                if (random.nextDouble() < 0.05 * level) {  // 5% kans per level
                    ServerWorld world = (ServerWorld) user.getWorld();
                    ItemStack itemStack = new ItemStack(SKELETON_TRANSFORMER, 1);
                    world.spawnEntity(new ItemEntity(world, target.getX(), target.getY(), target.getZ(), itemStack));
                }
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMinPower(int level) {
        return 10 + (level - 1) * 5;
    }

    @Override
    public int getMaxPower(int level) {
        return getMinPower(level) + 20;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}

