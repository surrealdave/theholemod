
package pile.item.crafting;

import pile.item.ItemRawDongfish;
import pile.item.ItemCookedDongfish;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@ElementsThePile.ModElement.Tag
public class RecipeDongfishCook extends ElementsThePile.ModElement {
	public RecipeDongfishCook(ElementsThePile instance) {
		super(instance, 321);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemRawDongfish.block, (int) (1)), new ItemStack(ItemCookedDongfish.block, (int) (1)), 1F);
	}
}
