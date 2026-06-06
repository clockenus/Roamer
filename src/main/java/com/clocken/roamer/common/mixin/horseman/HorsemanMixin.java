package com.clocken.roamer.common.mixin.horseman;

import com.teamabnormals.caverns_and_chasms.core.other.tags.CCInstrumentTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Instrument;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "io.github.mortuusars.horseman.Horseman$Items")
public class HorsemanMixin {

    // CCInstrumentTags.MELODY_COPPER_HORNS
    @Redirect(
            method = "lambda$static$0()Lio/github/mortuusars/horseman/world/item/CopperHornItem;",
            at = @At(value = "FIELD", target = "Lnet/minecraft/tags/InstrumentTags;GOAT_HORNS:Lnet/minecraft/tags/TagKey;", opcode = Opcodes.GETSTATIC)
    )
    private static TagKey<Instrument> roamer$redirectGOAT_HORNS() {
        return CCInstrumentTags.MELODY_COPPER_HORNS;
    }
}
