package pile.procedure;

import pile.item.ItemFallenMeteorItem;

import pile.ThePileVariables;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureFallenMeteorItemItemInHandTick extends ElementsThePile.ModElement {
	public ProcedureFallenMeteorItemItemInHandTick(ElementsThePile instance) {
		super(instance, 328);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FallenMeteorItemItemInHandTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FallenMeteorItemItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		double dist = 0;
		if ((!(((ThePileVariables.MapVariables.get(world).mondayZ) == 0) && ((ThePileVariables.MapVariables.get(world).mondayX) == 0)))) {
			dist = (double) Math.sqrt((Math.pow(((ThePileVariables.MapVariables.get(world).mondayZ) - (entity.posZ)), 2)
					+ Math.pow(((ThePileVariables.MapVariables.get(world).mondayX) - (entity.posX)), 2)));
			if (((dist) <= 20)) {
				if (entity instanceof EntityPlayer && !world.isRemote) {
					((EntityPlayer) entity).sendStatusMessage(new TextComponentString("The energy is very close now..."), (true));
				}
			} else if (((dist) >= 10000)) {
				if (entity instanceof EntityPlayer && !world.isRemote) {
					((EntityPlayer) entity).sendStatusMessage(new TextComponentString("You are too far away... Try moving somewhere else..."),
							(true));
				}
			} else {
				if (entity instanceof EntityPlayer && !world.isRemote) {
					((EntityPlayer) entity).sendStatusMessage(
							new TextComponentString(((Math.round((dist))) + "" + (" blocks from a mysterious energy..."))), (true));
				}
			}
		} else {
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("There is no energy here... You will have to make your own way..."),
						(true));
			}
		}
		if (((Math.random() * 100) <= 30)) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(ItemFallenMeteorItem.block, (int) (1)).getItem(), -1, (int) 1,
						null);
		}
	}
}
