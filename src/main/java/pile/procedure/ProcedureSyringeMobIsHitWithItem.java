package pile.procedure;

import pile.item.ItemSyringe;
import pile.item.ItemMolboBloodSyringe;
import pile.item.ItemGoblinBloodSyringe;

import pile.entity.EntityMolbo;
import pile.entity.EntityLongMolbo;
import pile.entity.EntityHoleMolbo;
import pile.entity.EntityGoblin;

import pile.ElementsThePile;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureSyringeMobIsHitWithItem extends ElementsThePile.ModElement {
	public ProcedureSyringeMobIsHitWithItem(ElementsThePile instance) {
		super(instance, 223);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SyringeMobIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof EntityMolbo.EntityCustom)
				|| ((entity instanceof EntityHoleMolbo.EntityCustom) || (entity instanceof EntityLongMolbo.EntityCustom)))) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemSyringe.block, (int) (1)).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemMolboBloodSyringe.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		} else if ((entity instanceof EntityGoblin.EntityCustom)) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemSyringe.block, (int) (1)).getItem(), -1, (int) 1, null);
			if (entity instanceof EntityPlayer) {
				ItemStack _setstack = new ItemStack(ItemGoblinBloodSyringe.block, (int) (1));
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
			}
		}
	}
}
