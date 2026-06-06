package com.clocken.roamer.common.registry;

import com.clocken.roamer.Roamer;
import com.clocken.roamer.common.recipe.ShapedFixedRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Roamer.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, ShapedFixedRecipe.Serializer> FIXED_RECIPE = SERIALIZERS.register("shaped_fixed", ShapedFixedRecipe.Serializer::new);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
