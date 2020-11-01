package pile.procedure;

import pile.ElementsThePile;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

@ElementsThePile.ModElement.Tag
public class ProcedureItsComing extends ElementsThePile.ModElement {
	public ProcedureItsComing(ElementsThePile instance) {
		super(instance, 308);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ItsComing!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ItsComing!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ItsComing!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ItsComing!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ItsComing!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double _x = 0;
		double _y = 0;
		double _z = 0;
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 100, true);
		}
		if (!world.isRemote) {
			world.createExplosion(null, (int) (x + 20), (int) y, (int) z, (float) 100, true);
		}
		if (!world.isRemote) {
			world.createExplosion(null, (int) (x - 20), (int) y, (int) z, (float) 100, true);
		}
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) (z + 20), (float) 100, true);
		}
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) (z - 20), (float) 100, true);
		}
		if (!world.isRemote) {
			world.createExplosion(null, (int) (x + 10), (int) y, (int) (z + 10), (float) 100, true);
		}
		if (!world.isRemote) {
			world.createExplosion(null, (int) (x + 10), (int) y, (int) (z - 10), (float) 100, true);
		}
		if (!world.isRemote) {
			world.createExplosion(null, (int) (x - 10), (int) y, (int) (z - 10), (float) 100, true);
		}
		if (!world.isRemote) {
			world.createExplosion(null, (int) (x - 10), (int) y, (int) (z + 10), (float) 100, true);
		}
		entity.world.removeEntity(entity);
		_x = (double) (x - 8);
		_z = (double) (z - 8);
		for (int index0 = 0; index0 < (int) (16); index0++) {
			_x = (double) ((_x) + 1);
			for (int index1 = 0; index1 < (int) (16); index1++) {
				_z = (double) ((_z) + 1);
				for (int index2 = 0; index2 < (int) (255); index2++) {
					_y = (double) ((_z) + 1);
					if ((!(world.isAirBlock(new BlockPos((int) x, (int) y, (int) z))))) {
						world.setBlockToAir(new BlockPos((int) (_x), (int) (_z), (int) (_z)));
					}
				}
			}
		}
	}
}
