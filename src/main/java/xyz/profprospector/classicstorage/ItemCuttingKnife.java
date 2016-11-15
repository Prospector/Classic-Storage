package xyz.profprospector.classicstorage;

import com.raoulvdberge.refinedstorage.RS;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by McKeever on 13-Nov-16.
 */
public class ItemCuttingKnife extends Item {

    public ItemCuttingKnife() {
        setUnlocalizedName("classicstorage:cuttingknife");
        setRegistryName("cuttingknife");
        setCreativeTab(RS.INSTANCE.tab);
        setMaxDamage(127);
        setMaxStackSize(1);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(itemStack.getItem(), 1, itemStack.getItemDamage() + 1);
    }
}
