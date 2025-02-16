package com.miikaoskari.ae2_universal_press.datagen;

import appeng.core.definitions.AEItems;
import appeng.datagen.providers.tags.ConventionTags;
import appeng.recipes.handlers.InscriberProcessType;
import appeng.recipes.handlers.InscriberRecipeBuilder;
import com.miikaoskari.ae2_universal_press.AEUPItems;
import com.miikaoskari.ae2_universal_press.Ae2UniversalPress;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
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

        makePrint(recipeOutput, "calculation_processor",
                AEItems.CALCULATION_PROCESSOR_PRINT,
                Ingredient.of(AEItems.CERTUS_QUARTZ_CRYSTAL));

        makePrint(recipeOutput, "engineering_processor",
                AEItems.ENGINEERING_PROCESSOR_PRINT,
                Ingredient.of(ConventionTags.DIAMOND));

        makePrint(recipeOutput, "logic_processor",
                AEItems.LOGIC_PROCESSOR_PRINT,
                Ingredient.of(ConventionTags.GOLD_INGOT));

        makePrint(recipeOutput, "silicon",
                AEItems.SILICON_PRINT,
                Ingredient.of(ConventionTags.SILICON));
    }

    private void makePrint(RecipeOutput consumer,
                           String name,
                           ItemLike print,
                           Ingredient printMaterial) {
        // Making the print
        InscriberRecipeBuilder.inscribe(printMaterial, print, 1)
                .setTop(Ingredient.of(AEUPItems.UNIVERSAL_PRESS))
                .setMode(InscriberProcessType.INSCRIBE)
                .save(consumer, Ae2UniversalPress.makeId("inscriber/" + name + "_print"));

        // Copying the press
        InscriberRecipeBuilder.inscribe(Items.IRON_BLOCK, AEUPItems.UNIVERSAL_PRESS, 1)
                .setTop(Ingredient.of(AEUPItems.UNIVERSAL_PRESS))
                .setMode(InscriberProcessType.INSCRIBE)
                .save(consumer, Ae2UniversalPress.makeId("inscriber/" + name + "_press"));
    }

}
