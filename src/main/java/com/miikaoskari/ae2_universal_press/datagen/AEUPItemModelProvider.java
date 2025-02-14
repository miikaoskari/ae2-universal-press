package com.miikaoskari.ae2_universal_press.datagen;

import appeng.datagen.providers.models.ItemModelProvider;
import com.miikaoskari.ae2_universal_press.AEUPItems;
import com.miikaoskari.ae2_universal_press.Ae2UniversalPress;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class AEUPItemModelProvider extends ItemModelProvider {
    public AEUPItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(AEUPItems.UNIVERSAL_PRESS.get());
    }
}
