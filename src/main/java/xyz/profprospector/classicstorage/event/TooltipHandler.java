package xyz.profprospector.classicstorage.event;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.profprospector.classicstorage.ClassicStorage;

/**
 * Created by McKeever on 14-Nov-16.
 */
public class TooltipHandler {

    @SubscribeEvent
    public void tooltipEvent(ItemTooltipEvent event) {
        for (ItemStack stack : ClassicStorage.hide) {
            if (event.getItemStack().isItemEqual(stack)) {
                event.getToolTip().clear();
                event.getToolTip().add(TextFormatting.RED + "This item has been disabled by " + TextFormatting.BLUE + TextFormatting.ITALIC + "Classic Storage");
            }
        }
    }
}
