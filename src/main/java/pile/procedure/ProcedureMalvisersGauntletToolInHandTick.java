package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.world.WorldServer;
import net.minecraft.world.World;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureMalvisersGauntletToolInHandTick extends ElementsThePile.ModElement {
	public ProcedureMalvisersGauntletToolInHandTick(ElementsThePile instance) {
		super(instance, 375);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MalvisersGauntletToolInHandTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MalvisersGauntletToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (world instanceof WorldServer)
			((WorldServer) world).spawnParticle(EnumParticleTypes.CRIT, (entity.posX), ((entity.posY) + 1), (entity.posZ), (int) 5, 0.5, 2, 0.5, 0.1,
					new int[0]);
	}
}
