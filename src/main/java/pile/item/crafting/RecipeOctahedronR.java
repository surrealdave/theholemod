
package pile.item.crafting;

import pile.item.ItemOctahedron;

import pile.block.BlockOctahedronOre;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@ElementsThePile.ModElement.Tag
public class RecipeOctahedronR extends ElementsThePile.ModElement {
	public RecipeOctahedronR(ElementsThePile instance) {
		super(instance, 287);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockOctahedronOre.block, (int) (1)), new ItemStack(ItemOctahedron.block, (int) (0)), 0F);
	}
}
