package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityLightningBolt;

@ElementsThePile.ModElement.Tag
public class ProcedureFijiWaterBlockDestroyedByPlayer extends ElementsThePile.ModElement {
	public ProcedureFijiWaterBlockDestroyedByPlayer(ElementsThePile instance) {
		super(instance, 138);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FijiWaterBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FijiWaterBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FijiWaterBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FijiWaterBlockDestroyedByPlayer!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 10, true);
		}
	}
}
