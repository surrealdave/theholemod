
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
public class ItemMetalocrab extends ElementsThePile.ModElement {
	@GameRegistry.ObjectHolder("pile:metalocrab")
	public static final Item block = null;
	public ItemMetalocrab(ElementsThePile instance) {
		super(instance, 111);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("pile:metalocrab", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("metalocrab", ElementsThePile.sounds.get(new ResourceLocation("pile:pile.record.metalocrab")));
			setUnlocalizedName("metalocrab");
			setRegistryName("metalocrab");
			setCreativeTab(TabThePile.tab);
		}
	}
}
