package com.clocken.roamer.common.registry;

import com.clocken.roamer.Roamer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Roamer.MODID);

    public static final Supplier<CreativeModeTab> ITEMS_TAB = CREATIVE_MODE_TAB.register("items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(RItems.STONE_KNIFE.get()))
                    .title(Component.translatable("creativetab.recore.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(RItems.STONE_KNIFE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}