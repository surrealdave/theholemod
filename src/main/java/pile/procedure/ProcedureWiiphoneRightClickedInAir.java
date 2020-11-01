package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureWiiphoneRightClickedInAir extends ElementsThePile.ModElement {
	public ProcedureWiiphoneRightClickedInAir(ElementsThePile instance) {
		super(instance, 263);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WiiphoneRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityPlayer) {
			((EntityPlayer) entity).capabilities.isFlying = (!((entity instanceof EntityPlayer)
					? ((EntityPlayer) entity).capabilities.isCreativeMode
					: false));
			((EntityPlayer) entity).sendPlayerAbilities();
		}
	}
}
