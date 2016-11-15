package xyz.profprospector.classicstorage;

import com.raoulvdberge.refinedstorage.RSItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by McKeever on 23-Oct-16.
 */
@Mod(modid = "classicstorage", name = "Classic Storage", version = "1.0.0", dependencies = "after:refinedstorage", acceptedMinecraftVersions = "[1.10.2]")
public class ClassicStorage {

    @Mod.Instance("classicstorage")
    public static ClassicStorage instance;

    public static Item cuttingKnife = new ItemCuttingKnife();
    public static Item parts = new ItemParts();
    public static ItemStack knife = new ItemStack(cuttingKnife, 1, OreDictionary.WILDCARD_VALUE);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.register(cuttingKnife);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.PROCESSOR, 1, 1), " k ", "rgr", " s ", 'k', knife, 'r', "dustRedstone", 'g', "ingotGold", 's', "itemSilicon"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.PROCESSOR, 1, 2), " k ", "rdr", " s ", 'k', knife, 'r', "dustRedstone", 'd', "gemDiamond", 's', "itemSilicon"));

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
