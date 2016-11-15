package xyz.profprospector.classicstorage;

import com.raoulvdberge.refinedstorage.RSItems;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * Created by McKeever on 14-Nov-16.
 */
@mezz.jei.api.JEIPlugin
public class CSJeiPlugin extends BlankModPlugin {
    @Override
    public void register(
            @Nonnull
                    IModRegistry registry) {
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();

        jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(RSItems.PROCESSOR, 1, 0));
        jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(RSItems.PROCESSOR, 1, 3));
        jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(RSItems.PROCESSOR, 1, 6));
    }

    @Override
    public void registerItemSubtypes(@Nonnull ISubtypeRegistry subtypeRegistry) {
    }
}