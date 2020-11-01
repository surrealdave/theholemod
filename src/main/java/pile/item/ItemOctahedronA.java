
package pile.item;

import pile.creativetab.TabThePile;

import pile.ElementsThePile;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

@ElementsThePile.ModElement.Tag
public class ItemOctahedronA extends ElementsThePile.ModElement {
	@GameRegistry.ObjectHolder("pile:octahedronahelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("pile:octahedronabody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("pile:octahedronalegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("pile:octahedronaboots")
	public static final Item boots = null;
	public ItemOctahedronA(ElementsThePile instance) {
		super(instance, 96);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("OCTAHEDRONA", "pile:octahedron_", 40, new int[]{5, 7, 8, 5}, 28,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 1f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("octahedronahelmet")
				.setRegistryName("octahedronahelmet").setCreativeTab(TabThePile.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("octahedronabody")
				.setRegistryName("octahedronabody").setCreativeTab(TabThePile.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("octahedronalegs")
				.setRegistryName("octahedronalegs").setCreativeTab(TabThePile.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("octahedronaboots")
				.setRegistryName("octahedronaboots").setCreativeTab(TabThePile.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("pile:octahedronahelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("pile:octahedronabody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("pile:octahedronalegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("pile:octahedronaboots", "inventory"));
	}
}
