
package pile.item;

import pile.procedure.ProcedureSDGRAPPFoodEaten;

import pile.creativetab.TabThePile;

import pile.ElementsThePile;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

@ElementsThePile.ModElement.Tag
public class ItemCookedDreamFruit extends ElementsThePile.ModElement {
	@GameRegistry.ObjectHolder("pile:cookeddreamfruit")
	public static final Item block = null;
	public ItemCookedDreamFruit(ElementsThePile instance) {
		super(instance, 359);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("pile:cookeddreamfruit", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(1, 0.5f, false);
			setUnlocalizedName("cookeddreamfruit");
			setRegistryName("cookeddreamfruit");
			setAlwaysEdible();
			setCreativeTab(TabThePile.tab);
			setMaxStackSize(64);
		}

		@Override
		public int getMaxItemUseDuration(ItemStack stack) {
			return 16;
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

		@Override
		protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity) {
			super.onFoodEaten(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureSDGRAPPFoodEaten.executeProcedure($_dependencies);
			}
		}
	}
}
