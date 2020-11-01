package pile.procedure;

import pile.entity.EntityAngryBrogle;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureBroglePlantBlockDestroyedByPlayer extends ElementsThePile.ModElement {
	public ProcedureBroglePlantBlockDestroyedByPlayer(ElementsThePile instance) {
		super(instance, 215);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BroglePlantBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BroglePlantBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BroglePlantBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BroglePlantBlockDestroyedByPlayer!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((Math.random() <= 0.1)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityAngryBrogle.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		}
	}
}
