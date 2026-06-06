package com.clocken.roamer.common.mixin.horseman;

import io.github.mortuusars.horseman.world.item.CopperHornItem;
import io.github.mortuusars.horseman.world.summoning.CallResult;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static io.github.mortuusars.horseman.world.summoning.CallResult.NO_BOUND_HORSE;

@Mixin(CopperHornItem.class)
public class CopperHornItemMixin {

    // no tooltip
    @Inject(method = "appendHoverText",
            at = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/world/item/InstrumentItem;appendHoverText(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/Item$TooltipContext;Ljava/util/List;Lnet/minecraft/world/item/TooltipFlag;)V",
                shift = At.Shift.AFTER),
            cancellable = true)
    public void roamer$appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag, CallbackInfo ci) {
        ci.cancel();
    }

    // no horse not bound message
    @Inject(method = "getCallResultMessage", at = @At("HEAD"), cancellable = true)
    public void roamer$getCallResultMessage(CallResult result, CallbackInfoReturnable<Component> cir) {
        if (result == NO_BOUND_HORSE) {
            cir.setReturnValue(null);
        }
    }

    // no pitch change if horse not bound
    @Inject(method = "getSoundPitchFromCallResult", at = @At("HEAD"), cancellable = true)
    public void roamer$getSoundPitchFromCallResult(CallResult result, CallbackInfoReturnable<Float> cir) {
        if (result == NO_BOUND_HORSE) {
            cir.setReturnValue(1.0F);
        }
    }
}
