package xyz.profprospector.classicstorage.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import xyz.profprospector.classicstorage.items.ItemParts;

import static xyz.profprospector.classicstorage.ClassicStorage.cuttingKnife;
import static xyz.profprospector.classicstorage.ClassicStorage.parts;

/**
 * Created by McKeever on 14-Nov-16.
 */
public class ClientProxy extends CommonProxy {

    static void registerItemModel(Item i, int meta) {
        ResourceLocation loc = i.getRegistryName();
        ModelLoader.setCustomModelResourceLocation(i, meta, new ModelResourceLocation(loc, "inventory"));
    }

    static void registerItemModel(Item i, int meta, String variant) {
        ResourceLocation loc = i.getRegistryName();
        ModelLoader.setCustomModelResourceLocation(i, meta, new ModelResourceLocation(loc, "type=" + variant));
    }

    @Override
    public void registerRenders() {
        registerItemModel(cuttingKnife, 0);
        for (int i = 0; i < ItemParts.types.length; ++i) {
            String[] name = ItemParts.types.clone();
            registerItemModel(parts, i, name[i]);
        }
    }
}
