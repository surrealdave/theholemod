package pile.procedure;

import pile.potion.PotionMolboEffect;

import pile.item.ItemSyringe;
import pile.item.ItemMolboHeroin;

import pile.ElementsThePile;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureMolboHeroinRightClickedInAir extends ElementsThePile.ModElement {
	public ProcedureMolboHeroinRightClickedInAir(ElementsThePile instance) {
		super(instance, 180);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MolboHeroinRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionMolboEffect.potion, (int) 1800, (int) 1));
		if (entity instanceof EntityPlayer) {
			ItemStack _setstack = new ItemStack(ItemSyringe.block, (int) (1));
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
		}
		if (entity instanceof EntityPlayer)
			((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemMolboHeroin.block, (int) (1)).getItem(), -1, (int) 1, null);
	}
}
