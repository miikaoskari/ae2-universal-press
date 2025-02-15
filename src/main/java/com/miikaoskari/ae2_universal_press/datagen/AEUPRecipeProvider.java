package com.miikaoskari.ae2_universal_press.datagen;

import appeng.api.ids.AETags;
import appeng.core.definitions.AEItems;
import appeng.recipes.handlers.InscriberRecipeBuilder;
import com.miikaoskari.ae2_universal_press.AEUPItems;
import com.miikaoskari.ae2_universal_press.items.ItemUniversalPress;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class AEUPRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public AEUPRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, provider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        // Universal Press
        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.MISC, AEUPItems.UNIVERSAL_PRESS)
                .requires(AEItems.CALCULATION_PROCESSOR_PRESS)
                .requires(AEItems.ENGINEERING_PROCESSOR_PRESS)
                .requires(AEItems.LOGIC_PROCESSOR_PRESS)
                .requires(AEItems.SILICON_PRESS)
                .unlockedBy("has_item", has(AEItems.CALCULATION_PROCESSOR_PRESS))
                .unlockedBy("has_item", has(AEItems.ENGINEERING_PROCESSOR_PRESS))
                .unlockedBy("has_item", has(AEItems.LOGIC_PROCESSOR_PRESS))
                .unlockedBy("has_item", has(AEItems.SILICON_PRESS))
                .save(recipeOutput);


        // TODO: Inscriber recipes for Universal Press
        // Can maybe use tags??


    }

}
