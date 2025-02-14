package com.miikaoskari.ae2_universal_press.items;

import appeng.api.AECapabilities;
import appeng.items.AEBaseItem;
import appeng.recipes.handlers.InscriberRecipeBuilder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class ItemUniversalPress extends Item {
    public ItemUniversalPress(Properties properties) {
        super(properties.stacksTo(1));
    }
}
