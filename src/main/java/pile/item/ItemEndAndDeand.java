
package pile.item;

import pile.creativetab.TabThePile;

import pile.ElementsThePile;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

@ElementsThePile.ModElement.Tag
public class ItemEndAndDeand extends ElementsThePile.ModElement {
	@GameRegistry.ObjectHolder("pile:endanddeand")
	public static final Item block = null;
	public ItemEndAndDeand(ElementsThePile instance) {
		super(instance, 112);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("pile:endanddeand", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("endanddeand", ElementsThePile.sounds.get(new ResourceLocation("pile:pile.record.endanddeand")));
			setUnlocalizedName("endanddeand");
			setRegistryName("endanddeand");
			setCreativeTab(TabThePile.tab);
		}
	}
}
