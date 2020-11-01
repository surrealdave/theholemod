
package pile.item.crafting;

import pile.block.BlockMondaystoneBricks;
import pile.block.BlockMondaystone;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@ElementsThePile.ModElement.Tag
public class RecipeMondaybrickR extends ElementsThePile.ModElement {
	public RecipeMondaybrickR(ElementsThePile instance) {
		super(instance, 310);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockMondaystone.block, (int) (1)), new ItemStack(BlockMondaystoneBricks.block, (int) (1)), 1F);
	}
}
