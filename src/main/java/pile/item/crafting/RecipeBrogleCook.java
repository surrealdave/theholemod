
package pile.item.crafting;

import pile.item.ItemCookedBrogle;
import pile.item.ItemBrogle;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@ElementsThePile.ModElement.Tag
public class RecipeBrogleCook extends ElementsThePile.ModElement {
	public RecipeBrogleCook(ElementsThePile instance) {
		super(instance, 132);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemBrogle.block, (int) (1)), new ItemStack(ItemCookedBrogle.block, (int) (1)), 0F);
	}
}
