package pile.procedure;

import pile.item.ItemTruffle;
import pile.item.ItemSDGRAPP;
import pile.item.ItemHydnellum;
import pile.item.ItemDavecoin;
import pile.item.ItemBlueteeth;

import pile.ElementsThePile;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.Container;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

@ElementsThePile.ModElement.Tag
public class ProcedureTradeDealer extends ElementsThePile.ModElement {
	public ProcedureTradeDealer(ElementsThePile instance) {
		super(instance, 292);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TradeDealer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double fungusChance = 0;
		double numberInReturn = 0;
		double chosenFungus = 0;
		if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				if (entity instanceof EntityPlayerMP) {
					Container _current = ((EntityPlayerMP) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (0))).getItem() == new ItemStack(ItemDavecoin.block, (int) (1)).getItem())) {
			fungusChance = (double) (75 * Math.random());
			if (entity instanceof EntityPlayerMP) {
				Container _current = ((EntityPlayerMP) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (0))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
			if (((fungusChance) <= 2)) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemSDGRAPP.block, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			} else if (((fungusChance) <= 5)) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemBlueteeth.block, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			} else if (((fungusChance) <= 10)) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemHydnellum.block, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			} else if (((fungusChance) <= 20)) {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(ItemTruffle.block, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			} else {
				if (entity instanceof EntityPlayer) {
					ItemStack _setstack = new ItemStack(Blocks.RED_MUSHROOM, (int) (1));
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(((EntityPlayer) entity), _setstack);
				}
			}
		}
	}
}
