package xyz.profprospector.classicstorage.compat;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import net.minecraft.item.ItemStack;
import xyz.profprospector.classicstorage.ClassicStorage;

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

        for (ItemStack stack : ClassicStorage.hide) {
            jeiHelpers.getItemBlacklist().addItemToBlacklist(stack);
        }
    }

    @Override
    public void registerItemSubtypes(@Nonnull ISubtypeRegistry subtypeRegistry) {
    }
}