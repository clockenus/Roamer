package com.clocken.roamer.common.mixin.nomansland;

import com.farcr.nomansland.common.block.GroundPickupBlock;
import com.farcr.nomansland.common.definitions.BlockDefinition;
import com.farcr.nomansland.common.registry.blocks.NMLBlocks;
import com.farcr.nomansland.common.registry.items.NMLItems;
import com.ninni.twigs.item.PebbleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Supplier;

@Mixin(NMLBlocks.class)
public abstract class NMLBlocksMixin {
    @Shadow
    public static <T extends Block> BlockDefinition<T> registerNoItem(String name, Supplier<T> block) {
        return null;
    }

    // re-registering PEBBLES to twigs PebbleItem
    @Redirect(method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/farcr/nomansland/common/registry/blocks/NMLBlocks;register(Ljava/lang/String;Ljava/util/function/Supplier;)Lcom/farcr/nomansland/common/definitions/BlockDefinition;",
                    ordinal = 10
            ))
    private static <T extends Block> BlockDefinition<T> roamer$clinit(String name, Supplier<T> block) {
        BlockDefinition<T> definition = (BlockDefinition<T>) registerNoItem("pebbles", () -> new GroundPickupBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).noCollission().instabreak().sound(SoundType.STONE).pushReaction(PushReaction.DESTROY)));
        NMLItems.register(name, () -> new PebbleItem((Block)definition.get(), new Item.Properties()));
        return definition;
    }
}
