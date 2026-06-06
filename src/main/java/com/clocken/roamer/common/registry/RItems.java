package com.clocken.roamer.common.registry;

import com.clocken.roamer.Roamer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.KnifeItem;

import static vectorwing.farmersdelight.common.registry.ModItems.knifeItem;

public class RItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Roamer.MODID);

    public static final DeferredItem<Item> STONE_KNIFE = ITEMS.register("stone_knife", () -> new KnifeItem(Tiers.WOOD, knifeItem(Tiers.WOOD)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
