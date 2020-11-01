package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureMeteorOnInitialEntitySpawn extends ElementsThePile.ModElement {
	public ProcedureMeteorOnInitialEntitySpawn(ElementsThePile instance) {
		super(instance, 331);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MeteorOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MeteorOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MeteorOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MeteorOnInitialEntitySpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		if (((Math.random() * 100) >= 20)) {
			entity.world.removeEntity(entity);
		} else {
			entity.setFire((int) 120);
			entity.setPositionAndUpdate(x, (y + 100), z);
		}
	}
}
