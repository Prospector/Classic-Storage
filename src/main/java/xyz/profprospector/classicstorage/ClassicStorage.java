package xyz.profprospector.classicstorage;

import com.raoulvdberge.refinedstorage.RSBlocks;
import com.raoulvdberge.refinedstorage.RSItems;
import com.raoulvdberge.refinedstorage.api.solderer.ISoldererRecipe;
import com.raoulvdberge.refinedstorage.apiimpl.API;
import com.raoulvdberge.refinedstorage.item.ItemUpgrade;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import xyz.profprospector.classicstorage.event.TooltipHandler;
import xyz.profprospector.classicstorage.items.ItemCuttingKnife;
import xyz.profprospector.classicstorage.items.ItemParts;
import xyz.profprospector.classicstorage.proxy.CommonProxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by McKeever on 23-Oct-16.
 */
@Mod(modid = "classicstorage", name = "Classic Storage", version = "1.0.0", dependencies = "required-after:refinedstorage;required-after:JEI;after:*", acceptedMinecraftVersions = "[1.10.2]")
public class ClassicStorage {

    @Mod.Instance("classicstorage")
    public static ClassicStorage instance;
    public static Item cuttingKnife = new ItemCuttingKnife();
    public static Item parts = new ItemParts();
    public static ItemStack knife = new ItemStack(cuttingKnife, 1, OreDictionary.WILDCARD_VALUE);
    public static ItemStack basicAssembly = new ItemStack(parts, 1, 0);
    public static ItemStack advancedAssembly = new ItemStack(parts, 1, 1);
    public static ItemStack basicProcessor = new ItemStack(parts, 1, 2);
    public static ItemStack advancedProcessor = new ItemStack(parts, 1, 3);
    public static ItemStack functionCore = new ItemStack(parts, 1, 4);
    public static ItemStack quartzFiber = new ItemStack(parts, 1, 5);
    public static List<ItemStack> hide = new ArrayList<ItemStack>();
    public static List<ItemStack> recipeRemove = new ArrayList<ItemStack>();

    @SidedProxy(clientSide = "xyz.profprospector.classicstorage.proxy.ClientProxy", serverSide = "xyz.profprospector.classicstorage.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.register(cuttingKnife);
        GameRegistry.register(parts);

        hide.add(new ItemStack(RSItems.PROCESSOR, 1, 0));
        hide.add(new ItemStack(RSItems.PROCESSOR, 1, 1));
        hide.add(new ItemStack(RSItems.PROCESSOR, 1, 2));
        hide.add(new ItemStack(RSItems.PROCESSOR, 1, 3));
        hide.add(new ItemStack(RSItems.PROCESSOR, 1, 4));
        hide.add(new ItemStack(RSItems.PROCESSOR, 1, 5));
        hide.add(new ItemStack(RSItems.PROCESSOR, 1, 6));
        hide.add(new ItemStack(RSItems.CORE, 1, 0));
        hide.add(new ItemStack(RSItems.CORE, 1, 1));
        hide.add(new ItemStack(RSItems.FLUID_STORAGE_PART, 1, 0));
        hide.add(new ItemStack(RSItems.FLUID_STORAGE_PART, 1, 1));
        hide.add(new ItemStack(RSItems.FLUID_STORAGE_PART, 1, 2));
        hide.add(new ItemStack(RSItems.FLUID_STORAGE_PART, 1, 3));
        hide.add(new ItemStack(RSItems.QUARTZ_ENRICHED_IRON));
        hide.add(new ItemStack(RSBlocks.MACHINE_CASING));
        hide.add(new ItemStack(RSBlocks.SOLDERER));


        recipeRemove.addAll(hide);
        recipeRemove.add(new ItemStack(RSBlocks.CONTROLLER));
        recipeRemove.add(new ItemStack(RSBlocks.DISK_DRIVE));
        recipeRemove.add(new ItemStack(RSBlocks.GRID, 1, 0));
        recipeRemove.add(new ItemStack(RSBlocks.GRID, 1, 1));
        recipeRemove.add(new ItemStack(RSBlocks.GRID, 1, 2));
        recipeRemove.add(new ItemStack(RSBlocks.GRID, 1, 3));
        recipeRemove.add(new ItemStack(RSBlocks.CRAFTING_MONITOR));
        recipeRemove.add(new ItemStack(RSBlocks.PROCESSING_PATTERN_ENCODER));
        recipeRemove.add(new ItemStack(RSBlocks.CRAFTER));
        recipeRemove.add(new ItemStack(RSBlocks.STORAGE, 1, 0));
        recipeRemove.add(new ItemStack(RSBlocks.STORAGE, 1, 1));
        recipeRemove.add(new ItemStack(RSBlocks.STORAGE, 1, 2));
        recipeRemove.add(new ItemStack(RSBlocks.STORAGE, 1, 3));
        recipeRemove.add(new ItemStack(RSBlocks.FLUID_STORAGE, 1, 0));
        recipeRemove.add(new ItemStack(RSBlocks.FLUID_STORAGE, 1, 1));
        recipeRemove.add(new ItemStack(RSBlocks.FLUID_STORAGE, 1, 2));
        recipeRemove.add(new ItemStack(RSBlocks.FLUID_STORAGE, 1, 3));
        recipeRemove.add(new ItemStack(RSItems.STORAGE_DISK, 1, 0));
        recipeRemove.add(new ItemStack(RSItems.STORAGE_DISK, 1, 1));
        recipeRemove.add(new ItemStack(RSItems.STORAGE_DISK, 1, 2));
        recipeRemove.add(new ItemStack(RSItems.STORAGE_DISK, 1, 3));
        recipeRemove.add(new ItemStack(RSItems.STORAGE_PART, 1, 0));
        recipeRemove.add(new ItemStack(RSItems.STORAGE_PART, 1, 1));
        recipeRemove.add(new ItemStack(RSItems.STORAGE_PART, 1, 2));
        recipeRemove.add(new ItemStack(RSItems.STORAGE_PART, 1, 3));
        recipeRemove.add(new ItemStack(RSItems.FLUID_STORAGE_DISK, 1, 0));
        recipeRemove.add(new ItemStack(RSItems.FLUID_STORAGE_DISK, 1, 1));
        recipeRemove.add(new ItemStack(RSItems.FLUID_STORAGE_DISK, 1, 2));
        recipeRemove.add(new ItemStack(RSItems.FLUID_STORAGE_DISK, 1, 3));
        recipeRemove.add(new ItemStack(RSBlocks.CABLE));
        recipeRemove.add(new ItemStack(RSBlocks.IMPORTER));
        recipeRemove.add(new ItemStack(RSBlocks.EXPORTER));
        recipeRemove.add(new ItemStack(RSBlocks.INTERFACE));
        recipeRemove.add(new ItemStack(RSBlocks.FLUID_INTERFACE));
        recipeRemove.add(new ItemStack(RSBlocks.EXTERNAL_STORAGE));
        recipeRemove.add(new ItemStack(RSBlocks.RELAY));
        recipeRemove.add(new ItemStack(RSBlocks.DETECTOR));
        recipeRemove.add(new ItemStack(RSBlocks.CONSTRUCTOR));
        recipeRemove.add(new ItemStack(RSBlocks.DESTRUCTOR));
        recipeRemove.add(new ItemStack(RSBlocks.WIRELESS_TRANSMITTER));
        recipeRemove.add(new ItemStack(RSBlocks.DISK_MANIPULATOR));
        recipeRemove.add(new ItemStack(RSItems.WIRELESS_CRAFTING_MONITOR));
        recipeRemove.add(new ItemStack(RSItems.WIRELESS_GRID));
        recipeRemove.add(new ItemStack(RSBlocks.NETWORK_RECEIVER));
        recipeRemove.add(new ItemStack(RSBlocks.NETWORK_TRANSMITTER));
        recipeRemove.add(new ItemStack(RSItems.WRENCH));
        recipeRemove.add(new ItemStack(RSItems.UPGRADE, 1, 0));
        recipeRemove.add(new ItemStack(RSItems.GRID_FILTER));
        recipeRemove.add(new ItemStack(RSItems.NETWORK_CARD));

        API.instance().getSoldererRegistry().getRecipes().get(1);

        List<ItemStack> outs = new ArrayList<ItemStack>();

        List<ISoldererRecipe> soldererRecipes = API.instance().getSoldererRegistry().getRecipes();
        Iterator<ISoldererRecipe> iter = soldererRecipes.iterator();
        while (iter.hasNext()) {
            ISoldererRecipe next = iter.next();
            outs.add(next.getResult());
        }
        for (ItemStack o : outs) {
            API.instance().getSoldererRegistry().removeRecipe(o);
        }

        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        Iterator<IRecipe> it = recipes.iterator();
        while (it.hasNext()) {
            ItemStack is = it.next().getRecipeOutput();
            for (ItemStack stack : recipeRemove)
                if (is != null && is.isItemEqual(stack))
                    it.remove();
        }

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(parts, 4, 5), "dustRedstone", "gemQuartz", "dustGlowstone"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(RSBlocks.CABLE, quartzFiber, "dustRedstone", "dustRedstone"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(RSBlocks.RELAY, RSBlocks.CABLE, Blocks.REDSTONE_TORCH));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cuttingKnife, 1, 0), "q  ", "qi ", "  s", 'q', "gemQuartz", 'i', "ingotIron", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(basicAssembly, " k ", "rgr", " s ", 'k', knife, 'r', "dustRedstone", 'g', "ingotGold", 's', "itemSilicon"));
        GameRegistry.addRecipe(new ShapedOreRecipe(advancedAssembly, " k ", "rdr", " s ", 'k', knife, 'r', "dustRedstone", 'd', "gemDiamond", 's', "itemSilicon"));
        GameRegistry.addRecipe(new ShapedOreRecipe(functionCore, "iqi", "gbg", "iqi", 'i', "ingotIron", 'q', "gemQuartz", 'g', "dustRedstone", 'b', basicProcessor));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.CONTROLLER), "iqi", "qaq", "iqi", 'i', "ingotIron", 'q', "gemQuartz", 'a', advancedProcessor));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.IMPORTER), " c ", "ifi", " p ", 'i', "ingotIron", 'f', RSBlocks.INTERFACE, 'p', Blocks.STICKY_PISTON, 'c', RSBlocks.CABLE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.EXPORTER), " c ", "ifi", " p ", 'i', "ingotIron", 'f', RSBlocks.INTERFACE, 'p', Blocks.PISTON, 'c', RSBlocks.CABLE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.WIRELESS_TRANSMITTER), " e ", "iqi", " c ", 'i', "ingotIron", 'e', Items.ENDER_PEARL, 'q', quartzFiber, 'c', RSBlocks.CABLE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.NETWORK_TRANSMITTER), "eee", "ifi", "aaa", 'i', "ingotIron", 'e', Items.ENDER_PEARL, 'f', functionCore, 'a', advancedProcessor));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.NETWORK_RECEIVER), "aaa", "ifi", "eee", 'i', "ingotIron", 'e', Items.ENDER_PEARL, 'f', functionCore, 'a', advancedProcessor));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.EXTERNAL_STORAGE), " c ", " f ", "iii", 'i', "ingotIron", 'f', RSBlocks.INTERFACE, 'c', RSBlocks.CABLE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.DISK_MANIPULATOR), "ggg", "dcd", "ibi", 'i', "ingotIron", 'g', "blockGlass", 'd', RSBlocks.DISK_DRIVE, 'b', basicProcessor, 'c', RSBlocks.CABLE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.INTERFACE), "igi", "cfg", "igi", 'i', "ingotIron", 'f', functionCore, 'g', "blockGlass", 'c', RSBlocks.CABLE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.FLUID_INTERFACE), "igi", "cfb", "igi", 'i', "ingotIron", 'f', functionCore, 'g', "blockGlass", 'c', RSBlocks.CABLE, 'b', Items.BUCKET));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.DESTRUCTOR), "rrr", "ifi", "ici", 'i', "ingotIron", 'f', functionCore, 'r', "dustRedstone", 'c', RSBlocks.CABLE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.CONSTRUCTOR), "ggg", "ifi", "ici", 'i', "ingotIron", 'f', functionCore, 'g', "dustGlowstone", 'c', RSBlocks.CABLE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.DETECTOR), " p ", "rbr", "ici", 'i', "ingotIron", 'p', Items.COMPARATOR, 'r', "dustRedstone", 'b', basicProcessor, 'c', RSBlocks.CABLE));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.DISK_DRIVE), "ibi", "gcg", "ibi", 'i', "ingotIron", 'g', "blockGlass", 'c', Blocks.CHEST, 'b', basicProcessor));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.GRID, 1, 0), "iig", "cfg", "iig", 'i', "ingotIron", 'g', "blockGlass", 'c', RSBlocks.CABLE, 'f', functionCore));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.GRID, 1, 1), "iig", "cpt", "iig", 'i', "ingotIron", 'g', "blockGlass", 'c', Blocks.CRAFTING_TABLE, 'p', new ItemStack(RSItems.STORAGE_PART, 1, 0), 't', new ItemStack(RSBlocks.GRID, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.GRID, 1, 2), "iig", "cpt", "iig", 'i', "ingotIron", 'g', "blockGlass", 'c', RSItems.PATTERN, 'p', new ItemStack(RSItems.STORAGE_PART, 1, 0), 't', new ItemStack(RSBlocks.GRID, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.GRID, 1, 3), "iig", "cpt", "iig", 'i', "ingotIron", 'g', "blockGlass", 'c', Items.BUCKET, 'p', new ItemStack(RSItems.STORAGE_PART, 1, 0), 't', new ItemStack(RSBlocks.GRID, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.CRAFTING_MONITOR, 1, 0), "iig", "cpg", "iig", 'i', "ingotIron", 'g', "blockGlass", 'c', RSBlocks.CABLE, 'p', basicProcessor));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.CRAFTER, 1, 0), "ifi", "aca", "igi", 'i', "ingotIron", 'g', "ingotGold", 'c', Blocks.CRAFTING_TABLE, 'f', functionCore, 'a', advancedProcessor));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.PROCESSING_PATTERN_ENCODER, 1, 0), "ifi", "ipi", "iii", 'i', "ingotIron", 'p', RSItems.PATTERN, 'f', functionCore));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.STORAGE, 1, 0), "iri", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.STORAGE, 1, 1), "iri", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 1)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.STORAGE, 1, 2), "iri", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 2)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.STORAGE, 1, 3), "iri", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 3)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.FLUID_STORAGE, 1, 0), "ibi", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 0), 'b', Items.BUCKET));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.FLUID_STORAGE, 1, 1), "ibi", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 1), 'b', Items.BUCKET));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.FLUID_STORAGE, 1, 2), "ibi", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 2), 'b', Items.BUCKET));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSBlocks.FLUID_STORAGE, 1, 3), "ibi", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 3), 'b', Items.BUCKET));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.STORAGE_PART, 1, 0), "rqr", "qbq", "rqr", 'r', "dustRedstone", 'b', basicProcessor, 'q', "gemQuartz"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.STORAGE_PART, 1, 1), "rbr", "pgp", "rpr", 'r', "dustRedstone", 'g', "blockGlass", 'b', basicProcessor, 'p', new ItemStack(RSItems.STORAGE_PART, 1, 0)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.STORAGE_PART, 1, 2), "rbr", "pgp", "rpr", 'r', "dustRedstone", 'g', "blockGlass", 'b', advancedProcessor, 'p', new ItemStack(RSItems.STORAGE_PART, 1, 1)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.STORAGE_PART, 1, 3), "rbr", "pgp", "rpr", 'r', "dustRedstone", 'g', "blockGlass", 'b', advancedProcessor, 'p', new ItemStack(RSItems.STORAGE_PART, 1, 2)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.STORAGE_DISK, 1, 0), "grg", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 0), 'g', "blockGlass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.STORAGE_DISK, 1, 1), "grg", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 1), 'g', "blockGlass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.STORAGE_DISK, 1, 2), "grg", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 2), 'g', "blockGlass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.STORAGE_DISK, 1, 3), "grg", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 3), 'g', "blockGlass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.FLUID_STORAGE_DISK, 1, 0), "gbg", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 0), 'b', Items.BUCKET, 'g', "blockGlass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.FLUID_STORAGE_DISK, 1, 1), "gbg", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 1), 'b', Items.BUCKET, 'g', "blockGlass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.FLUID_STORAGE_DISK, 1, 2), "gbg", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 2), 'b', Items.BUCKET, 'g', "blockGlass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.FLUID_STORAGE_DISK, 1, 3), "gbg", "rpr", "iii", 'r', "dustRedstone", 'i', "ingotIron", 'p', new ItemStack(RSItems.STORAGE_PART, 1, 3), 'b', Items.BUCKET, 'g', "blockGlass"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.WIRELESS_GRID), "iei", "qgq", "iai", 'q', "gemQuartz", 'i', "ingotIron", 'g', new ItemStack(RSBlocks.GRID, 1, 0), 'a', advancedProcessor, 'e', Items.ENDER_PEARL));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.WIRELESS_CRAFTING_MONITOR), "iei", "qgq", "iai", 'q', "gemQuartz", 'i', "ingotIron", 'g', new ItemStack(RSBlocks.CRAFTING_MONITOR), 'a', advancedProcessor, 'e', Items.ENDER_PEARL));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.WRENCH), "i i", " q ", " i ", 'q', "gemQuartz", 'i', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.UPGRADE, 1, 0), "igi", "ibi", "igi", 'g', "blockGlass", 'b', basicProcessor, 'i', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.GRID_FILTER, 1, 0), "ipi", "php", "ipi", 'p', Items.PAPER, 'h', Blocks.HOPPER, 'i', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(RSItems.NETWORK_CARD, 1, 0), "iqi", "pap", "iqi", 'p', Items.PAPER, 'q', "gemQuartz", 'i', "ingotIron"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(RSItems.UPGRADE, 1, 1), new ItemStack(RSItems.UPGRADE, 1, 0), Items.ENDER_PEARL, "dustRedstone"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(RSItems.UPGRADE, 1, 2), new ItemStack(RSItems.UPGRADE, 1, 0), Items.SUGAR, "dustRedstone"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(RSItems.UPGRADE, 1, 3), new ItemStack(RSItems.UPGRADE, 1, 0), Blocks.CRAFTING_TABLE, "dustRedstone"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(RSItems.UPGRADE, 1, 5), new ItemStack(RSItems.UPGRADE, 1, 0), Items.NETHER_STAR, "dustRedstone"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(RSItems.UPGRADE, 1, 6), new ItemStack(RSItems.UPGRADE, 1, 0), Items.ENCHANTED_BOOK.getEnchantedItemStack(new EnchantmentData(Enchantments.SILK_TOUCH, 1)), "dustRedstone"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(ItemUpgrade.initializeForFortune(1), new ItemStack(RSItems.UPGRADE, 1, 0), Items.ENCHANTED_BOOK.getEnchantedItemStack(new EnchantmentData(Enchantments.FORTUNE, 1)), "dustRedstone"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(ItemUpgrade.initializeForFortune(2), new ItemStack(RSItems.UPGRADE, 1, 0), Items.ENCHANTED_BOOK.getEnchantedItemStack(new EnchantmentData(Enchantments.FORTUNE, 2)), "dustRedstone"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(ItemUpgrade.initializeForFortune(3), new ItemStack(RSItems.UPGRADE, 1, 0), Items.ENCHANTED_BOOK.getEnchantedItemStack(new EnchantmentData(Enchantments.FORTUNE, 3)), "dustRedstone"));
        GameRegistry.addSmelting(basicAssembly, basicProcessor, 0.5F);
        GameRegistry.addSmelting(advancedAssembly, advancedProcessor, 0.5F);

        proxy.registerRenders();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new TooltipHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
