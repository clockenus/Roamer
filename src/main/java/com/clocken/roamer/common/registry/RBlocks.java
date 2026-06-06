package com.clocken.roamer.common.registry;

import com.clocken.roamer.Roamer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Roamer.MODID);

    public static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        RItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return BLOCKS.register(name, block);
    }

    // crafting tables
//    public static final DeferredBlock<Block> SPRUCE_CRAFTING_TABLE = register("spruce_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> BIRCH_CRAFTING_TABLE = register("birch_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> JUNGLE_CRAFTING_TABLE = register("jungle_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> ACACIA_CRAFTING_TABLE = register("acacia_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> DARK_OAK_CRAFTING_TABLE = register("dark_oak_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> MANGROVE_CRAFTING_TABLE = register("mangrove_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> CHERRY_CRAFTING_TABLE = register("cherry_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> BAMBOO_CRAFTING_TABLE = register("bamboo_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> CRIMSON_CRAFTING_TABLE = register("crimson_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> WARPED_CRAFTING_TABLE = register("warped_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));

//    public static final DeferredBlock<Block> PINE_CRAFTING_TABLE = register("pine_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> MAPLE_CRAFTING_TABLE = register("maple_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> WALNUT_CRAFTING_TABLE = register("walnut_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));
//    public static final DeferredBlock<Block> WILLOW_CRAFTING_TABLE = register("willow_crafting_table", () -> new CraftingTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
