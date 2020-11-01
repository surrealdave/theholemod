
package pile.item.crafting;

import pile.item.ItemYam;
import pile.item.ItemRoastYam;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@ElementsThePile.ModElement.Tag
public class RecipeRoastYamR extends ElementsThePile.ModElement {
	public RecipeRoastYamR(ElementsThePile instance) {
		super(instance, 235);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemYam.block, (int) (1)), new ItemStack(ItemRoastYam.block, (int) (1)), 0F);
	}
}
