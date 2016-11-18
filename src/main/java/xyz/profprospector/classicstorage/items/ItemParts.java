package xyz.profprospector.classicstorage.items;

import com.raoulvdberge.refinedstorage.RS;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by McKeever on 14-Nov-16.
 */
public class ItemParts extends Item {
    public static final String[] types = new String[]{"basicAssembly", "advancedAssembly", "basicProcessor", "advancedProcessor", "functionCore", "quartzFiber"};

    public ItemParts() {
        setUnlocalizedName("classicstorage:parts");
        setRegistryName("parts");
        setCreativeTab(RS.INSTANCE.tab);
        setHasSubtypes(true);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
        for (int meta = 0; meta < types.length; meta++) {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        if (meta < 0 || meta >= types.length) {
            meta = 0;
        }
        return super.getUnlocalizedName() + "." + types[meta];
    }
}
