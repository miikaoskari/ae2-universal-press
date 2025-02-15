package com.miikaoskari.ae2_universal_press;

import com.miikaoskari.ae2_universal_press.items.ItemUniversalPress;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.miikaoskari.ae2_universal_press.Ae2UniversalPress.MODID;

public class AEUPItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Register the Universal Press item
    public static final DeferredItem<Item> UNIVERSAL_PRESS = ITEMS.register("universal_press", () -> new ItemUniversalPress(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static void registerTabs(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    // Creates a creative tab with the id "ae2_universal_press:example_tab"
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> UNIVERSAL_PRESS_TAB = CREATIVE_MODE_TABS.register("universal_press_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.ae2_universal_press")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> AEUPItems.UNIVERSAL_PRESS.get().getDefaultInstance()).displayItems((parameters, output) -> {
        output.accept(AEUPItems.UNIVERSAL_PRESS.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
    }).build());
}
