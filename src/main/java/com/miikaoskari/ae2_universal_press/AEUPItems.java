package com.miikaoskari.ae2_universal_press;

import com.miikaoskari.ae2_universal_press.items.ItemUniversalPress;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AEUPItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ae2UniversalPress.MODID);

    // Register the Universal Press item
    public static final DeferredItem<Item> UNIVERSAL_PRESS = ITEMS.register("universal_press", () -> new ItemUniversalPress(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
