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
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class AEUPRecipeProvider extends RecipeProvider {

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
                .requires(AEItems.SILICON_PRESS);



        // TODO: Inscriber recipes for Universal Press
        // Can maybe use tags??


    }

}
