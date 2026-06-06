package com.clocken.roamer.common.item;

import com.farcr.nomansland.common.block.GroundPickupBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class StickBlock extends GroundPickupBlock {
    public StickBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (player.isCreative() && player.getInventory().hasAnyMatching((stack) -> stack.getItem() == Items.STICK)) {
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, (level.random.nextFloat() - level.random.nextFloat()) * 1.4F + 2.0F);
        } else {
            ItemStack item = new ItemStack(Items.STICK);
            if (!player.addItem(item)) {
                player.drop(item, false);
            } else {
                level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, (level.random.nextFloat() - level.random.nextFloat()) * 1.4F + 2.0F);
            }
        }

        level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
