package com.clocken.roamer.common.recipe;

import com.clocken.roamer.common.registry.RRecipeSerializers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

/**
 * A shaped recipe class that matches only the exact recipe pattern instead of symmetrical.
 * <p>
 *  Adapted from: <a href="https://github.com/Choonster-Minecraft-Mods/TestMod3/blob/1.21.x/src/main/java/choonster/testmod3/world/item/crafting/recipe/ShapedArmourUpgradeRecipe.java">Choonster-Minecraft-Mods/TestMod3</a>
 */
public class ShapedFixedRecipe extends ShapedRecipe {

    private ShapedFixedRecipe(
            final String group,
            final CraftingBookCategory category,
            final ShapedRecipePattern pattern,
            final ItemStack result,
            final boolean showNotification) {
        super(group, category, pattern, result, showNotification);
    }

    @Override
    public boolean matches(final CraftingInput input, final Level level) {
        int ingredientCount = 0;
        for (Ingredient ingredient : this.pattern.ingredients()) {
            if (!ingredient.isEmpty()) {
                ingredientCount++;
            }
        }
        if (input.ingredientCount() == ingredientCount) {
            if (input.width() == this.pattern.width() && input.height() == this.pattern.height()) {
                return this.patternMatches(input);
            }
        }
        return false;
    }

    private boolean patternMatches(CraftingInput input) {
        for (int i = 0; i < this.pattern.height(); i++) {
            for (int j = 0; j < this.pattern.width(); j++) {
                Ingredient ingredient;
                ingredient = this.pattern.ingredients().get(j + i * this.pattern.width());

                ItemStack itemstack = input.getItem(j, i);
                if (!ingredient.test(itemstack)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public RecipeSerializer<? extends ShapedRecipe> getSerializer() {
        return RRecipeSerializers.FIXED_RECIPE.get();
    }

    public static class Serializer extends ShapedRecipeSerializer<ShapedFixedRecipe> {
        public Serializer() {
            super(ShapedFixedRecipe::new);
        }
    }
}
