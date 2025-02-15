package com.miikaoskari.ae2_universal_press.datagen;

import com.miikaoskari.ae2_universal_press.Ae2UniversalPress;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Ae2UniversalPress.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Generate recipes
        dataGenerator.addProvider(event.includeServer(), new AEUPRecipeProvider(packOutput, lookupProvider));

        // Generate item models
        dataGenerator.addProvider(event.includeClient(), new AEUPItemModelProvider(packOutput, existingFileHelper));
    }
}
