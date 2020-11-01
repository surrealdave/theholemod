
package pile.item.crafting;

import pile.item.ItemDreamFruit;
import pile.item.ItemCookedDreamFruit;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@ElementsThePile.ModElement.Tag
public class RecipeDreamFruitR extends ElementsThePile.ModElement {
	public RecipeDreamFruitR(ElementsThePile instance) {
		super(instance, 360);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(ItemDreamFruit.block, (int) (1)), new ItemStack(ItemCookedDreamFruit.block, (int) (1)), 1F);
	}
}
