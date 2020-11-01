
package pile.creativetab;

import pile.item.ItemCrabItem;

import pile.ElementsThePile;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

@ElementsThePile.ModElement.Tag
public class TabThePile extends ElementsThePile.ModElement {
	public TabThePile(ElementsThePile instance) {
		super(instance, 131);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabthepile") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemCrabItem.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
