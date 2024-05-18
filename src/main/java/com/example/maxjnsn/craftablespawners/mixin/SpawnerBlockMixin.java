package com.example.maxjnsn.craftablespawners.mixin;

import net.minecraft.block.SpawnerBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SpawnerBlock.class)
public abstract class SpawnerBlockMixin {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void modifyProperties(CallbackInfo ci) {
    }
}
