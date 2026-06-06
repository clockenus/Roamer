package com.clocken.roamer.common.mixin.twigs;

import com.clocken.roamer.common.item.StickBlock;
import com.ninni.twigs.registry.TwigsBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Supplier;

@Mixin(TwigsBlocks.class)
public class TwigsBlocksMixin {

    // (FloorItemBlock) twig -> StickBlock (gives sticks + nml shape)
    @Redirect(method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/neoforged/neoforge/registries/DeferredRegister;register(Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/neoforged/neoforge/registries/DeferredHolder;",
                    ordinal = 2
            ))
    private static <I extends Block> DeferredHolder<Block, StickBlock> register(DeferredRegister<Block> instance, String name, Supplier<? extends I> sup) {
        return instance.register(name, () -> new StickBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).instabreak().noCollission().pushReaction(PushReaction.DESTROY)));
    }
}
