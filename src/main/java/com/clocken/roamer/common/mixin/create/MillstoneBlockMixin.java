package com.clocken.roamer.common.mixin.create;

import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.millstone.MillstoneBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MillstoneBlock.class)
public abstract class MillstoneBlockMixin implements ICogWheel {

    // model
    @Inject(
            method = "getShape(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/phys/shapes/CollisionContext;)Lnet/minecraft/world/phys/shapes/VoxelShape;",
            at = @At("HEAD"),
            cancellable = true)
    public void roamer$getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context, CallbackInfoReturnable<VoxelShape> cir) {
        cir.setReturnValue(AllShapes.CRATE_BLOCK_SHAPE);
    }

    // shaft up
    @Inject(
            method = "hasShaftTowards(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;)Z",
            at = @At("HEAD"),
            cancellable = true)
    public void roamer$hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(face == Direction.UP);
    }

    // no side cogs
    @Override
    public boolean isSmallCog() {
        return false;
    }
}
