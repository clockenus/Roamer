package com.clocken.roamer.common.mixin.minecraft;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Blocks.class)
public class BlocksMixin {

    // logs require tool for drop
    @ModifyArg(method = "log(Lnet/minecraft/world/level/material/MapColor;Lnet/minecraft/world/level/material/MapColor;)Lnet/minecraft/world/level/block/Block;", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/RotatedPillarBlock;<init>(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V"))
    private static BlockBehaviour.Properties recore$addProperty(BlockBehaviour.Properties properties) {
        return properties.requiresCorrectToolForDrops();
    }
}
