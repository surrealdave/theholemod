
package pile.item.crafting;

import pile.item.ItemCrabMeat;
import pile.item.ItemCrabItem;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@ElementsThePile.ModElement.Tag
public class RecipeCrabMeatR extends ElementsThePile.ModElement {
	public RecipeCrabMeatR(ElementsThePile instance) {
		super(instance, 250);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemCrabItem.block, (int) (1)), new ItemStack(ItemCrabMeat.block, (int) (1)), 0F);
	}
}
