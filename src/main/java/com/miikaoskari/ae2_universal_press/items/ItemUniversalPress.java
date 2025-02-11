package com.miikaoskari.ae2_universal_press.items;

import appeng.api.AECapabilities;
import appeng.items.AEBaseItem;
import appeng.recipes.handlers.InscriberRecipeBuilder;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class ItemUniversalPress extends AEBaseItem {
    public ItemUniversalPress(Properties properties) {
        super(properties.stacksTo(1));
    }
}
