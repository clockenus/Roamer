package com.clocken.roamer;

import com.clocken.roamer.common.registry.RBlocks;
import com.clocken.roamer.common.registry.RCreativeModeTabs;
import com.clocken.roamer.common.registry.RItems;
import com.clocken.roamer.common.registry.RRecipeSerializers;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(Roamer.MODID)
public class Roamer {
    public static final String MODID = "roamer";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_NAME = "Roamer";

    public Roamer(IEventBus modEventBus) {
        RRecipeSerializers.register(modEventBus);
        RItems.register(modEventBus);
        RBlocks.register(modEventBus);
        RCreativeModeTabs.register(modEventBus);

        LOGGER.info(MOD_NAME + " was loaded.");
    }

    public static ResourceLocation resource(String path) {
        return ResourceLocation.fromNamespaceAndPath(Roamer.MODID, path);
    }
}
