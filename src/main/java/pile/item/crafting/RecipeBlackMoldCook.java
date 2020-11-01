
package pile.item.crafting;

import pile.item.ItemSterileMold;

import pile.block.BlockDeadMold;

import pile.ElementsThePile;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@ElementsThePile.ModElement.Tag
public class RecipeBlackMoldCook extends ElementsThePile.ModElement {
	public RecipeBlackMoldCook(ElementsThePile instance) {
		super(instance, 252);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockDeadMold.block, (int) (1)), new ItemStack(ItemSterileMold.block, (int) (1)), 50F);
	}
}
